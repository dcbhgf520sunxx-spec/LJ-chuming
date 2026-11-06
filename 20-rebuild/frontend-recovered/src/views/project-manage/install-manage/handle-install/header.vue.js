import { ref as i } from "vue";
import { watch as w } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as V } from "vue";
import { createElementBlock as _ } from "vue";
import { withDirectives as N } from "vue";
import { vShow as x } from "vue";
import { unref as e } from "vue";
import { createElementVNode as A } from "vue";
import { createVNode as r } from "vue";
import { withKeys as b } from "vue";
import { withCtx as I } from "vue";
import { createBlock as B } from "vue";
import { createTextVNode as L } from "vue";
import { createCommentVNode as P } from "vue";
import { ElMessage as k } from "element-plus";
import { ElInput as q } from "element-plus";
import { m as K, K as c, tQ as U, F as j, B as z, q as M, C as O, tY as D, E as F } from "../../../../shared/runtime.js";
import { _ as R } from "./detail-confirm.vue.js";
const G = { class: "head-container" }, Y = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 }, globalProject: { type: Object, default: () => {
} } }, setup(u) {
  const { deliveryInstallEnumArr: g } = K("deliveryInstallEnumArr"), d = u, T = { projectId: { value: void 0, resetAble: false }, productType: d.globalProject.projectType === c.STEEL.V ? U.ARTIFACT.V : j.BOX.V, monomerId: void 0, areaId: void 0, name: void 0, serialNumber: void 0 }, { crud: o, query: a } = z(T), v = { key: "id", label: "name", value: "id" }, y = i([]), s = i(false), m = i([]);
  w(() => d.projectId, (n) => {
    n && (o.query.projectId = d.projectId, o.toQuery());
  }, { immediate: true, deep: true });
  function E(n) {
    y.value = n || [];
  }
  function C() {
    const n = o.data.filter((t) => t.reportQuantity && t.reportQuantity > 0);
    m.value = [], n.length > 0 ? (s.value = true, m.value = n) : k.error("请填写本次安装填报数量且大于0");
  }
  return (n, t) => {
    const h = p("common-radio-button"), Q = p("common-select"), f = q, S = p("common-button");
    return V(), _("div", G, [N(A("div", null, [r(h, { modelValue: e(a).productType, "onUpdate:modelValue": t[0] || (t[0] = (l) => e(a).productType = l), options: u.globalProject.projectType === e(c).STEEL.V ? e(g) : [e(j).BOX], type: "enum", class: "filter-item", onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), r(e(M), { ref: "monomerSelectRef", modelValue: e(a).monomerId, "onUpdate:modelValue": t[1] || (t[1] = (l) => e(a).monomerId = l), "project-id": e(a).projectId, "main-product-type": u.globalProject.projectType === e(c).STEEL.V ? e(a).productType : "", default: false, clearable: "", class: "filter-item", onChange: e(o).toQuery, onGetAreaInfo: E }, null, 8, ["modelValue", "project-id", "main-product-type", "onChange"]), r(Q, { modelValue: e(a).areaId, "onUpdate:modelValue": t[2] || (t[2] = (l) => e(a).areaId = l), options: y.value, type: "other", dataStructure: v, size: "default", clearable: "", placeholder: "请选择区域", class: "filter-item", style: { width: "200px" }, onChange: e(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), r(f, { modelValue: e(a).serialNumber, "onUpdate:modelValue": t[3] || (t[3] = (l) => e(a).serialNumber = l), modelModifiers: { trim: true }, placeholder: "编号搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: b(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(f, { modelValue: e(a).name, "onUpdate:modelValue": t[4] || (t[4] = (l) => e(a).name = l), modelModifiers: { trim: true }, placeholder: "名称搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: b(e(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(e(O))], 512), [[x, e(o).searchToggle]]), r(e(F), null, { viewLeft: I(() => {
      var l;
      return [e(o).permission.add && ((l = u.globalProject) == null ? void 0 : l.installReportMethod) === e(D).PC.V ? (V(), B(S, { key: 0, type: "primary", size: "default", disabled: e(o).data.length === 0, onClick: C }, { default: I(() => t[6] || (t[6] = [L("提交预览")])), _: 1, __: [6] }, 8, ["disabled"])) : P("", true)];
    }), _: 1 }), r(e(R), { modelValue: s.value, "onUpdate:modelValue": t[5] || (t[5] = (l) => s.value = l), submitList: m.value, projectId: e(o).query.projectId, productType: e(o).query.productType, onSuccess: e(o).toQuery }, null, 8, ["modelValue", "submitList", "projectId", "productType", "onSuccess"])]);
  };
} };
export {
  Y as default
};
