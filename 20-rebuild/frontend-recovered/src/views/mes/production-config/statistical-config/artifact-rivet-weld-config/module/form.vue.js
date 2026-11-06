import { ref as F } from "vue";
import { inject as g } from "vue";
import { computed as N } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as r } from "vue";
import { createBlock as c } from "vue";
import { withCtx as l } from "vue";
import { createVNode as i } from "vue";
import { unref as e } from "vue";
import { createTextVNode as f } from "vue";
import { toDisplayString as O } from "vue";
import { createElementVNode as Q } from "vue";
import { createCommentVNode as w } from "vue";
import { createElementBlock as k } from "vue";
import { Fragment as D } from "vue";
import { renderList as R } from "vue";
import { ElFormItem as q } from "element-plus";
import { ElTag as H } from "element-plus";
import { ElForm as K } from "element-plus";
import { t as M, ao as $, a$ as A, i as G, aT as v } from "../../../../../../shared/runtime.js";
const J = { key: 0 }, ee = { __name: "form", setup(W) {
  const { decimalPrecision: T } = M(), V = F(), C = { id: void 0, processObj: {}, artifactTypeId: void 0, structureProcessPriceList: [] }, U = g("processListObj"), h = g("artifactTypeList"), j = g("artifactTypeListObj"), { crud: n, CRUD: P, form: t } = $(C, V), u = N(() => {
    var s;
    return ((s = j.value[t.classificationId]) == null ? void 0 : s.typeProcessObj) || {};
  }), L = N(() => n.status.edit > 0), z = { classificationId: [{ required: true, message: "请选择构件类型", trigger: "change" }], numerical: [{ required: true, validator: (s, o, d) => {
    (!t.minNumerical || !t.maxNumerical) && d(new Error("请填写最小或最大数值")), d();
  }, message: "请填写构件截面", trigger: "blur" }] };
  function E() {
    for (const s in u.value) t.processObj[s] = u.value[s];
  }
  return P.HOOK.beforeSubmit = (s, o) => {
    s.form.artifactTypeId = s.query.id, s.form.structureProcessPriceList = A(s.form.processObj);
  }, (s, o) => {
    const d = p("common-button"), x = p("common-select"), m = q, b = H, _ = p("common-input-number"), B = K, S = p("common-dialog");
    return r(), c(S, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(n).cancelCU, visible: e(n).status.cu > 0, title: e(n).status.title, width: "500px" }, { titleRight: l(() => [i(d, { loading: e(n).status.cu === 2, type: "primary", size: "default", onClick: e(n).submitCU }, { default: l(() => o[3] || (o[3] = [f("确认")])), _: 1, __: [3] }, 8, ["loading", "onClick"])]), default: l(() => [i(B, { ref_key: "formRef", ref: V, model: e(t), rules: z, size: "default", "label-width": "110px", "label-position": "right" }, { default: l(() => [i(m, { label: "构件类型", prop: "classificationId" }, { default: l(() => [i(x, { modelValue: e(t).classificationId, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(t).classificationId = a), options: e(h), type: "other", class: "input-underline", dataStructure: { key: "id", label: "classificationName", value: "id" }, placeholder: "构件类型", disabled: L.value, style: { width: "100%" }, onChange: E }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), i(m, { label: "截面前缀", prop: "specPrefixStr" }, { default: l(() => [e(t).classificationId ? (r(), c(b, { key: 0 }, { default: l(() => {
      var a;
      return [f(O((a = e(j)[e(t).classificationId]) == null ? void 0 : a.specPrefixStr), 1)];
    }), _: 1 })) : (r(), c(b, { key: 1 }, { default: l(() => o[4] || (o[4] = [f("请选择构件类型")])), _: 1, __: [4] }))]), _: 1 }), i(m, { label: "构件截面", prop: "numerical" }, { default: l(() => [i(_, { modelValue: e(t).minNumerical, "onUpdate:modelValue": o[1] || (o[1] = (a) => e(t).minNumerical = a), step: 1, min: 0, max: e(t).maxNumerical, precision: 2, clearable: "", controls: false, size: "default", class: "input-underline", placeholder: "最小数值", style: { width: "45%" } }, null, 8, ["modelValue", "max"]), o[5] || (o[5] = Q("span", null, " ~ ", -1)), i(_, { modelValue: e(t).maxNumerical, "onUpdate:modelValue": o[2] || (o[2] = (a) => e(t).maxNumerical = a), step: 1, min: e(t).minNumerical, precision: 2, class: "input-underline", controls: false, size: "default", clearable: "", placeholder: "最大数值", style: { width: "45%" } }, null, 8, ["modelValue", "min"])]), _: 1, __: [5] }), e(G)(u.value) ? (r(), c(b, { key: 0, style: { width: "100%", "text-align": "center", "margin-bottom": "15px", "margin-top": "10px" }, type: "info", size: "default" }, { default: l(() => o[6] || (o[6] = [f(" 工序单价（元） ")])), _: 1, __: [6] })) : w("", true), (r(true), k(D, null, R(u.value, (a) => (r(), c(m, { key: a, label: e(U)[a.processId].name }, { default: l(() => {
      var I;
      return [i(x, { modelValue: e(t).processObj[a.processId].wageQuotaType, "onUpdate:modelValue": (y) => e(t).processObj[a.processId].wageQuotaType = y, options: e(v).ENUM, type: "enum", clearable: "", size: "default", class: "input-underline", placeholder: "计量方式", style: { width: "40%", "margin-right": "10px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"]), i(_, { modelValue: e(t).processObj[a.processId].price, "onUpdate:modelValue": (y) => e(t).processObj[a.processId].price = y, step: 1, min: 0, precision: e(T).mes, clearable: "", class: "input-underline", controls: false, placeholder: "单价", size: "default", style: { width: "30%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"]), (I = e(t).processObj[a.processId]) != null && I.wageQuotaType ? (r(), k("span", J, O(e(v).V[e(t).processObj[a.processId].wageQuotaType].unit), 1)) : w("", true)];
    }), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  ee as default
};
