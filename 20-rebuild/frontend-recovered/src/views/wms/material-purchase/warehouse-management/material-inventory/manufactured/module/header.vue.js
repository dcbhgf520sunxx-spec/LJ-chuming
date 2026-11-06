import { ref as N } from "vue";
import { onMounted as h } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as V } from "vue";
import { unref as e } from "vue";
import { createVNode as n } from "vue";
import { createBlock as b } from "vue";
import { createCommentVNode as c } from "vue";
import { withKeys as s } from "vue";
import { withCtx as y } from "vue";
import { ElInput as x } from "element-plus";
import { v0 as E, gF as T, Au as u, bZ as D, C as v, E as z, i as R, z as M } from "../../../../../../../shared/runtime.js";
import { u as F } from "../../../../../../../modules/use-header-info-847d35a5.js";
import { j as K } from "../../../../../../../modules/warehouse-management-aa3a73c1.js";
const B = { class: "head-container" }, _ = { key: 0 }, q = { __name: "header", props: { tableSelections: { type: Array, default: () => [] } }, emits: ["clearTableSelection", "getSelections", "handleClearSelection"], setup(P, { expose: U, emit: I }) {
  const { crud: p, query: a, updateListNumber: S } = F({ defaultBasicClass: E.STRUC_MANUFACTURED.V }), d = I, f = N();
  function j() {
    d("clearTableSelection"), d("handleClearSelection");
  }
  function w() {
    d("clearTableSelection"), d("handleClearSelection");
  }
  function t() {
    p.toQuery(), j();
  }
  async function A() {
    const i = await K();
    R(i) && (i.forEach((l) => {
      l.fullProjectName = M(l);
    }), f.value = i);
  }
  return h(() => {
    A();
  }), U({ updateListNumber: S }), (i, l) => {
    const g = C("common-radio-button"), k = C("common-select"), r = x;
    return m(), V("div", B, [e(p).searchToggle ? (m(), V("div", _, [n(T, { modelValue: e(a).workshopIds, "onUpdate:modelValue": l[0] || (l[0] = (o) => e(a).workshopIds = o), "factory-id": e(a).factoryId, class: "filter-item", clearable: "", multiple: "", placeholder: "仓库", style: { width: "200px" }, onChange: t }, null, 8, ["modelValue", "factory-id"]), n(g, { modelValue: e(a).basicClass, "onUpdate:modelValue": l[1] || (l[1] = (o) => e(a).basicClass = o), options: e(u).ENUM, unshowVal: [e(u).AUX_MANUFACTURED.V], class: "filter-item", size: "default", type: "enum", onChange: t }, null, 8, ["modelValue", "options", "unshowVal"]), n(k, { modelValue: e(a).projectId, "onUpdate:modelValue": l[2] || (l[2] = (o) => e(a).projectId = o), dataStructure: { key: "id", label: "fullProjectName", value: "id" }, options: f.value, class: "filter-item", clearable: "", filterable: "", placeholder: "请选择项目搜索", size: "default", onChange: t }, null, 8, ["modelValue", "options"]), e(a).basicClass === e(u).STRUC_MANUFACTURED.V ? (m(), b(D, { key: 0, areaId: e(a).areaId, "onUpdate:areaId": l[3] || (l[3] = (o) => e(a).areaId = o), monomerId: e(a).monomerId, "onUpdate:monomerId": l[4] || (l[4] = (o) => e(a).monomerId = o), areaDisabled: !e(a).projectId, filterArea: false, monomerDisabled: !e(a).projectId, "project-id": e(a).projectId, areaClearable: "", clearable: "", onChange: l[5] || (l[5] = (o) => e(p).toQuery()) }, null, 8, ["areaId", "monomerId", "areaDisabled", "monomerDisabled", "project-id"])) : c("", true), n(r, { modelValue: e(a).name, "onUpdate:modelValue": l[6] || (l[6] = (o) => e(a).name = o), class: "filter-item", clearable: "", placeholder: "可输入名称搜索", size: "default", style: { width: "200px" }, onClear: t, onKeyup: s(t, ["enter"]) }, null, 8, ["modelValue"]), n(r, { modelValue: e(a).manufacturedSn, "onUpdate:modelValue": l[7] || (l[7] = (o) => e(a).manufacturedSn = o), class: "filter-item", clearable: "", placeholder: "可输入编号搜索", size: "default", style: { width: "200px" }, onClear: t, onKeyup: s(t, ["enter"]) }, null, 8, ["modelValue"]), n(r, { modelValue: e(a).specification, "onUpdate:modelValue": l[8] || (l[8] = (o) => e(a).specification = o), class: "filter-item", clearable: "", placeholder: "可输入规格搜索", size: "default", style: { width: "200px" }, onClear: t, onKeyup: s(t, ["enter"]) }, null, 8, ["modelValue"]), e(a).basicClass === e(u).STRUC_MANUFACTURED.V ? (m(), b(r, { key: 1, modelValue: e(a).length, "onUpdate:modelValue": l[9] || (l[9] = (o) => e(a).length = o), class: "filter-item", clearable: "", placeholder: "可输入长度搜索", size: "default", style: { width: "200px" }, onClear: t, onKeyup: s(t, ["enter"]) }, null, 8, ["modelValue"])) : c("", true), n(r, { modelValue: e(a).material, "onUpdate:modelValue": l[10] || (l[10] = (o) => e(a).material = o), class: "filter-item", clearable: "", placeholder: "可输入材质搜索", size: "default", style: { width: "200px" }, onClear: t, onKeyup: s(t, ["enter"]) }, null, 8, ["modelValue"]), n(e(v), { onResetClick: w })])) : c("", true), n(e(z), null, { optLeft: y(() => l[11] || (l[11] = [])), viewLeft: y(() => l[12] || (l[12] = [])), _: 1 })]);
  };
} };
export {
  q as default
};
