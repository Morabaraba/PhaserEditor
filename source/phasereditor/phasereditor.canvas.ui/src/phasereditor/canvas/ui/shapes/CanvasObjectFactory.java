// The MIT License (MIT)
//
// Copyright (c) 2016 Arian Fornaris
//
// Permission is hereby granted, free of charge, to any person obtaining a
// copy of this software and associated documentation files (the
// "Software"), to deal in the Software without restriction, including
// without limitation the rights to use, copy, modify, merge, publish,
// distribute, sublicense, and/or sell copies of the Software, and to permit
// persons to whom the Software is furnished to do so, subject to the
// following conditions: The above copyright notice and this permission
// notice shall be included in all copies or substantial portions of the
// Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
// OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
// MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN
// NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
// DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
// OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE
// USE OR OTHER DEALINGS IN THE SOFTWARE.
package phasereditor.canvas.ui.shapes;

import phasereditor.canvas.core.AtlasSpriteModel;
import phasereditor.canvas.core.BaseObjectModel;
import phasereditor.canvas.core.ButtonSpriteModel;
import phasereditor.canvas.core.GroupModel;
import phasereditor.canvas.core.ImageSpriteModel;
import phasereditor.canvas.core.MissingAssetSpriteModel;
import phasereditor.canvas.core.MissingPrefabModel;
import phasereditor.canvas.core.SpritesheetSpriteModel;
import phasereditor.canvas.core.TextModel;
import phasereditor.canvas.core.TileSpriteModel;
import phasereditor.canvas.ui.editors.ObjectCanvas;

/**
 * @author arian
 *
 */
public class CanvasObjectFactory {
	public static BaseObjectControl<?> createObjectControl(ObjectCanvas canvas, BaseObjectModel model) {
		if (model instanceof GroupModel) {
			return new GroupControl(canvas, (GroupModel) model);
		} else if (model instanceof ImageSpriteModel) {
			return new ImageSpriteControl(canvas, (ImageSpriteModel) model);
		} else if (model instanceof SpritesheetSpriteModel) {
			return new SpritesheetSpriteControl(canvas, (SpritesheetSpriteModel) model);
		} else if (model instanceof AtlasSpriteModel) {
			AtlasSpriteControl control = new AtlasSpriteControl(canvas, (AtlasSpriteModel) model);
			return control;
		} else if (model instanceof TileSpriteModel) {
			return new TileSpriteControl(canvas, (TileSpriteModel) model);
		} else if (model instanceof ButtonSpriteModel) {
			return new ButtonSpriteControl(canvas, (ButtonSpriteModel) model);
		} else if (model instanceof MissingAssetSpriteModel) {
			return new MissingAssetControl(canvas, (MissingAssetSpriteModel) model);
		} else if (model instanceof MissingPrefabModel) {
			return new MissingPrefabControl(canvas, (MissingPrefabModel) model);
		} else if (model instanceof TextModel) {
			return new TextControl(canvas, (TextModel) model);
		}
		return null;
	}
}
