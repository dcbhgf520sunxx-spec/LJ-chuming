import { ref as n } from "vue";
import { watch as m } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as h } from "vue";
import { createVNode as a } from "vue";
import { unref as x } from "vue";
import { withKeys as f } from "vue";
import { withCtx as I } from "vue";
import { createTextVNode as v } from "vue";
import { withModifiers as y } from "vue";
import { ElInput as N } from "element-plus";
import { m as T } from "../../../../../../modules/use-scheduling-groups-e49a6ba2.js";
import { a3 as Q, bZ as U } from "../../../../../../shared/runtime.js";
import "../../../../../../modules/artifact-f1b0ca44.js";
const k = { class: "head-container" }, G = { __name: "header", props: { projectId: { type: Number, default: void 0 } }, emits: ["toQuery"], setup(j, { emit: b }) {
  const u = b, l = j, e = n({ projectId: l.projectId }), s = n(false), V = n({ list: [], obj: {} });
  w(), m(() => l.projectId, () => {
    e.value.projectId = l.projectId;
  }), m(() => l.projectId, () => {
    e.value.projectId = l.projectId;
  });
  async function w() {
    if (!s.value) try {
      V.value = await T({ productType: Q.ARTIFACT.V }, true), s.value = true;
    } catch (d) {
      console.log("获取生产组的信息失败", d);
    }
  }
  function r() {
    u("toQuery", e.value);
  }
  function _() {
    e.value = {}, u("toQuery", e.value);
  }
  return (d, t) => {
    const C = c("project-cascader"), p = N, i = c("common-button");
    return g(), h("div", k, [a(C, { modelValue: e.value.projectId, "onUpdate:modelValue": t[0] || (t[0] = (o) => e.value.projectId = o), clearable: "", class: "filter-item", style: { width: "270px" }, onChange: r }, null, 8, ["modelValue"]), a(x(U), { monomerId: e.value.monomerId, "onUpdate:monomerId": t[1] || (t[1] = (o) => e.value.monomerId = o), areaId: e.value.areaId, "onUpdate:areaId": t[2] || (t[2] = (o) => e.value.areaId = o), needConvert: "", clearable: "", "project-id": e.value.projectId, onChange: r }, null, 8, ["monomerId", "areaId", "project-id"]), a(p, { modelValue: e.value.artifactSerialNumber, "onUpdate:modelValue": t[3] || (t[3] = (o) => e.value.artifactSerialNumber = o), placeholder: "按构件编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: f(r, ["enter"]) }, null, 8, ["modelValue"]), a(p, { modelValue: e.value.serialNumber, "onUpdate:modelValue": t[4] || (t[4] = (o) => e.value.serialNumber = o), placeholder: "按零件编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: f(r, ["enter"]) }, null, 8, ["modelValue"]), a(i, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: y(r, ["stop"]) }, { default: I(() => t[5] || (t[5] = [v("搜索")])), _: 1, __: [5] }), a(i, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: y(_, ["stop"]) }, { default: I(() => t[6] || (t[6] = [v(" 重置 ")])), _: 1, __: [6] })]);
  };
} };
export {
  G as default
};
