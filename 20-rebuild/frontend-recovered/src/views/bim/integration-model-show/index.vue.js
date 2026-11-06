import { m, o as p } from "../../../shared/runtime.js";
import { b as c } from "../../../modules/bim-model-view-dbf77a11.js";
import { openBlock as s } from "vue";
import { createBlock as i } from "vue";
import { unref as o } from "vue";
import "../../../modules/bimfaceAPI-c2661893.js";
import "../../../modules/model-0ac957f7.js";
import "../../../modules/index-d6a37d29.js";
import "../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../modules/use-chart-59e4b63c.js";
import "../../../modules/index-18acf776.js";
const I = { __name: "index", setup(l) {
  const { globalProjectId: t, globalProject: r } = m(["globalProjectId", "globalProject"]), { maxHeight: a } = p({});
  return (n, g) => {
    var e;
    return s(), i(o(c), { showMonomerModel: false, projectId: o(t), projectName: (e = o(r)) == null ? void 0 : e.shortName, maxHeight: o(a) }, null, 8, ["projectId", "projectName", "maxHeight"]);
  };
} };
export {
  I as default
};
