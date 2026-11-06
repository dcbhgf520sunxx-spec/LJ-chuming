import { ref as S } from "vue";
import { inject as g } from "vue";
import { computed as O } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as r } from "vue";
import { createBlock as u } from "vue";
import { withCtx as s } from "vue";
import { createVNode as i } from "vue";
import { unref as e } from "vue";
import { createTextVNode as f } from "vue";
import { toDisplayString as N } from "vue";
import { createElementVNode as F } from "vue";
import { createCommentVNode as w } from "vue";
import { createElementBlock as k } from "vue";
import { Fragment as Q } from "vue";
import { renderList as R } from "vue";
import { ElFormItem as q } from "element-plus";
import { ElTag as D } from "element-plus";
import { ElForm as H } from "element-plus";
import { ao as K, a$ as M, i as $, aT as v } from "../../../../../../shared/runtime.js";
const A = { key: 0 }, Y = { __name: "form", setup(G) {
  const V = S(), T = { id: void 0, processObj: {}, boxTypeId: void 0, structureProcessPriceList: [] }, C = g("processListObj"), U = g("artifactTypeList"), x = g("artifactTypeListObj"), { crud: n, CRUD: h, form: o } = K(T, V), c = O(() => {
    var l;
    return ((l = x.value[o.classificationId]) == null ? void 0 : l.typeProcessObj) || {};
  }), L = O(() => n.status.edit > 0), z = { classificationId: [{ required: true, message: "请选择分段类型", trigger: "change" }], numerical: [{ required: true, validator: (l, a, d) => {
    (!o.minNumerical || !o.maxNumerical) && d(new Error("请填写最小或最大数值")), d();
  }, message: "请填写数值", trigger: "blur" }] };
  function E() {
    for (const l in c.value) o.processObj[l] = c.value[l];
  }
  return h.HOOK.beforeSubmit = (l, a) => {
    l.form.boxTypeId = l.query.id, l.form.structureProcessPriceList = M(l.form.processObj);
  }, (l, a) => {
    const d = p("common-button"), j = p("common-select"), m = q, b = D, _ = p("common-input-number"), P = H, B = p("common-dialog");
    return r(), u(B, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(n).cancelCU, visible: e(n).status.cu > 0, title: e(n).status.title, width: "500px" }, { titleRight: s(() => [i(d, { loading: e(n).status.cu === 2, type: "primary", size: "default", onClick: e(n).submitCU }, { default: s(() => a[3] || (a[3] = [f("确认")])), _: 1, __: [3] }, 8, ["loading", "onClick"])]), default: s(() => [i(P, { ref_key: "formRef", ref: V, model: e(o), rules: z, size: "default", "label-width": "110px", "label-position": "right" }, { default: s(() => [i(m, { label: "分段类型", prop: "classificationId" }, { default: s(() => [i(j, { modelValue: e(o).classificationId, "onUpdate:modelValue": a[0] || (a[0] = (t) => e(o).classificationId = t), options: e(U), type: "other", class: "input-underline", dataStructure: { key: "id", label: "name", value: "id" }, placeholder: "分段类型", disabled: L.value, style: { width: "100%" }, onChange: E }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), i(m, { label: "截面前缀", prop: "specPrefixStr" }, { default: s(() => [e(o).classificationId ? (r(), u(b, { key: 0 }, { default: s(() => {
      var t;
      return [f(N((t = e(x)[e(o).classificationId]) == null ? void 0 : t.specPrefixStr), 1)];
    }), _: 1 })) : (r(), u(b, { key: 1 }, { default: s(() => a[4] || (a[4] = [f("请选择分段类型")])), _: 1, __: [4] }))]), _: 1 }), i(m, { label: "数值", prop: "numerical" }, { default: s(() => [i(_, { modelValue: e(o).minNumerical, "onUpdate:modelValue": a[1] || (a[1] = (t) => e(o).minNumerical = t), step: 1, min: 0, max: e(o).maxNumerical, precision: 2, clearable: "", controls: false, size: "default", class: "input-underline", placeholder: "最小数值", style: { width: "45%" } }, null, 8, ["modelValue", "max"]), a[5] || (a[5] = F("span", null, " ~ ", -1)), i(_, { modelValue: e(o).maxNumerical, "onUpdate:modelValue": a[2] || (a[2] = (t) => e(o).maxNumerical = t), step: 1, min: e(o).minNumerical, precision: 2, class: "input-underline", controls: false, size: "default", clearable: "", placeholder: "最大数值", style: { width: "45%" } }, null, 8, ["modelValue", "min"])]), _: 1, __: [5] }), e($)(c.value) ? (r(), u(b, { key: 0, style: { width: "100%", "text-align": "center", "margin-bottom": "15px", "margin-top": "10px" }, type: "info", size: "default" }, { default: s(() => a[6] || (a[6] = [f(" 工序单价（元） ")])), _: 1, __: [6] })) : w("", true), (r(true), k(Q, null, R(c.value, (t) => (r(), u(m, { key: t, label: e(C)[t.processId].name }, { default: s(() => {
      var I;
      return [i(j, { modelValue: e(o).processObj[t.processId].wageQuotaType, "onUpdate:modelValue": (y) => e(o).processObj[t.processId].wageQuotaType = y, options: e(v).ENUM, type: "enum", clearable: "", size: "default", class: "input-underline", placeholder: "计量方式", style: { width: "40%", "margin-right": "10px" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"]), i(_, { modelValue: e(o).processObj[t.processId].price, "onUpdate:modelValue": (y) => e(o).processObj[t.processId].price = y, step: 1, min: 0, precision: 2, clearable: "", class: "input-underline", controls: false, placeholder: "单价", size: "default", style: { width: "30%" } }, null, 8, ["modelValue", "onUpdate:modelValue"]), (I = e(o).processObj[t.processId]) != null && I.wageQuotaType ? (r(), k("span", A, N(e(v).V[e(o).processObj[t.processId].wageQuotaType].unit), 1)) : w("", true)];
    }), _: 2 }, 1032, ["label"]))), 128))]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  Y as default
};
