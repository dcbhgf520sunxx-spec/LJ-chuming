import { ref as B } from "vue";
import { inject as g } from "vue";
import { computed as I } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as n } from "vue";
import { createBlock as u } from "vue";
import { withCtx as t } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { createTextVNode as b } from "vue";
import { toDisplayString as N } from "vue";
import { createElementVNode as S } from "vue";
import { createCommentVNode as w } from "vue";
import { createElementBlock as k } from "vue";
import { Fragment as F } from "vue";
import { renderList as Q } from "vue";
import { ElFormItem as R } from "element-plus";
import { ElTag as D } from "element-plus";
import { ElForm as q } from "element-plus";
import { ao as H, a$ as K, i as M, aT as v } from "../../../../../../shared/runtime.js";
const $ = { key: 0 }, Y = { __name: "form", setup(G) {
  const V = B(), T = { id: void 0, processObj: {}, artifactTypeId: void 0, structureProcessPriceList: [] }, C = g("processListObj"), U = g("assembleTypeList"), j = g("assembleTypeListObj"), { crud: i, CRUD: h, form: s } = H(T, V), m = I(() => {
    var a;
    return ((a = j.value[s.sysAssembleId]) == null ? void 0 : a.typeProcessObj) || {};
  }), L = I(() => i.status.edit > 0), z = { sysAssembleId: [{ required: true, message: "请选择单元件类型", trigger: "change" }], numerical: [{ required: true, validator: (a, o, d) => {
    (!s.minNumerical || !s.maxNumerical) && d(new Error("请填写最小或最大数值")), d();
  }, message: "请填写数值", trigger: "blur" }] };
  function E() {
    for (const a in m.value) s.processObj[a] = m.value[a];
  }
  return h.HOOK.beforeSubmit = (a, o) => {
    a.form.structureProcessPriceList = K(a.form.processObj);
  }, (a, o) => {
    const d = p("common-button"), x = p("common-select"), c = R, f = D, y = p("common-input-number"), P = q, A = p("common-dialog");
    return n(), u(A, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(i).cancelCU, visible: e(i).status.cu > 0, title: e(i).status.title, width: "500px" }, { titleRight: t(() => [r(d, { loading: e(i).status.cu === 2, type: "primary", size: "default", onClick: e(i).submitCU }, { default: t(() => o[3] || (o[3] = [b("确认")])), _: 1, __: [3] }, 8, ["loading", "onClick"])]), default: t(() => [r(P, { ref_key: "formRef", ref: V, model: e(s), rules: z, size: "default", "label-width": "110px", "label-position": "right" }, { default: t(() => [r(c, { label: "单元件类型", prop: "sysAssembleId" }, { default: t(() => [r(x, { modelValue: e(s).sysAssembleId, "onUpdate:modelValue": o[0] || (o[0] = (l) => e(s).sysAssembleId = l), options: e(U), type: "other", class: "input-underline", dataStructure: { key: "id", label: "name", value: "id" }, placeholder: "单元件类型", disabled: L.value, style: { width: "100%" }, onChange: E }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), r(c, { label: "截面前缀", prop: "specPrefixStr" }, { default: t(() => [e(s).sysAssembleId ? (n(), u(f, { key: 0 }, { default: t(() => {
      var l;
      return [b(N((l = e(j)[e(s).sysAssembleId]) == null ? void 0 : l.specPrefixStr), 1)];
    }), _: 1 })) : (n(), u(f, { key: 1 }, { default: t(() => o[4] || (o[4] = [b("请选择单元件类型")])), _: 1, __: [4] }))]), _: 1 }), r(c, { label: "数值", prop: "numerical" }, { default: t(() => [r(y, { modelValue: e(s).minNumerical, "onUpdate:modelValue": o[1] || (o[1] = (l) => e(s).minNumerical = l), step: 1, min: 0, max: e(s).maxNumerical, precision: 2, clearable: "", controls: false, size: "default", class: "input-underline", placeholder: "最小数值", style: { width: "45%" } }, null, 8, ["modelValue", "max"]), o[5] || (o[5] = S("span", null, " ~ ", -1)), r(y, { modelValue: e(s).maxNumerical, "onUpdate:modelValue": o[2] || (o[2] = (l) => e(s).maxNumerical = l), step: 1, min: e(s).minNumerical, precision: 2, class: "input-underline", controls: false, size: "default", clearable: "", placeholder: "最大数值", style: { width: "45%" } }, null, 8, ["modelValue", "min"])]), _: 1, __: [5] }), e(M)(m.value) ? (n(), u(f, { key: 0, style: { width: "100%", "text-align": "center", "margin-bottom": "15px", "margin-top": "10px" }, type: "info", size: "default" }, { default: t(() => o[6] || (o[6] = [b(" 工序单价（元） ")])), _: 1, __: [6] })) : w("", true), (n(true), k(F, null, Q(m.value, (l) => (n(), u(c, { key: l, label: e(C)[l.processId].name }, { default: t(() => {
      var O;
      return [r(x, { modelValue: e(s).processObj[l.processId].wageQuotaType, "onUpdate:modelValue": (_) => e(s).processObj[l.processId].wageQuotaType = _, options: e(v).ENUM, type: "enum", clearable: "", size: "default", class: "input-underline", placeholder: "计量方式", style: { width: "40%", "margin-right": "10px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"]), r(y, { modelValue: e(s).processObj[l.processId].price, "onUpdate:modelValue": (_) => e(s).processObj[l.processId].price = _, step: 1, min: 0, precision: 2, clearable: "", class: "input-underline", controls: false, placeholder: "单价", size: "default", style: { width: "30%" } }, null, 8, ["modelValue", "onUpdate:modelValue"]), (O = e(s).processObj[l.processId]) != null && O.wageQuotaType ? (n(), k("span", $, N(e(v).V[e(s).processObj[l.processId].wageQuotaType].unit), 1)) : w("", true)];
    }), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  Y as default
};
