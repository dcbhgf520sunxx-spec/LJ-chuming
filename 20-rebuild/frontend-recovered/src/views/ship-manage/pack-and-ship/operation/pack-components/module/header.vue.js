import { resolveComponent as i } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as c } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { ElInput as f } from "element-plus";
import { m4 as r, B as _, m as V, C as b } from "../../../../../../shared/runtime.js";
import y from "./monomer-slelct-area.vue.js";
import "../../../../../../modules/artifact-62fe68f7.js";
import "../../../../../../modules/use-product-lines-79a95221.js";
const g = { class: "head-container" }, M = { __name: "header", setup(E) {
  const m = { workshopId: void 0, areaId: void 0, monomerId: void 0, serialNumber: void 0, specification: void 0, manufactureType: r.HOMEMADE.V }, { crud: u, query: o } = _(m), { globalProjectId: d } = V(["globalProjectId", "globalProject"]);
  return (I, a) => {
    const s = i("common-radio-button"), l = f;
    return p(), c("div", g, [n(s, { modelValue: e(o).manufactureType, "onUpdate:modelValue": a[0] || (a[0] = (t) => e(o).manufactureType = t), options: e(r).ENUM, class: "filter-item", type: "enum", onChange: e(u).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(y, { "project-id": e(d) }, null, 8, ["project-id"]), n(l, { modelValue: e(o).serialNumber, "onUpdate:modelValue": a[1] || (a[1] = (t) => e(o).serialNumber = t), class: "filter-item", clearable: "", placeholder: "按编号搜索", style: { width: "200px" } }, null, 8, ["modelValue"]), n(l, { modelValue: e(o).specification, "onUpdate:modelValue": a[2] || (a[2] = (t) => e(o).specification = t), class: "filter-item", clearable: "", placeholder: "按规格搜索", style: { width: "200px" } }, null, 8, ["modelValue"]), n(b)]);
  };
} };
export {
  M as default
};
