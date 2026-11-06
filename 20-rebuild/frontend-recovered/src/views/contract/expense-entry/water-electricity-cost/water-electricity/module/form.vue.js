import { ref as v } from "vue";
import { computed as k } from "vue";
import { resolveComponent as f } from "vue";
import { resolveDirective as U } from "vue";
import { openBlock as A } from "vue";
import { createBlock as R } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as h } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { createTextVNode as g } from "vue";
import { withDirectives as S } from "vue";
import { ElFormItem as M } from "element-plus";
import { ElInputNumber as N } from "element-plus";
import { ElForm as j } from "element-plus";
import { t as z, ao as B, jj as D } from "../../../../../../shared/runtime.js";
const F = { style: { float: "right" } }, H = { class: "form" }, P = { __name: "form", props: { query: { type: Object } }, setup(C) {
  const { decimalPrecision: V } = z(), u = C, _ = v([]);
  for (let a = 1; a <= 12; a++) _.value.push({ id: a, name: a });
  const m = k(() => r.status.edit > 0), c = v(), w = { id: void 0, month: void 0, usedMete: void 0, totalAmount: void 0 }, { crud: r, form: t, CRUD: n } = B(w, c), b = (a, o, i) => {
    o || i(new Error("填写数据必须大于0")), i();
  }, x = { month: [{ required: true, message: "请选择月份", trigger: "blur" }], usedMete: [{ required: true, validator: b, trigger: "blur" }], totalAmount: [{ required: true, validator: b, trigger: "blur" }] };
  return n.HOOK.beforeToEdit = (a, o) => {
    console.log(o, "form");
  }, n.HOOK.beforeToQuery = async () => {
  }, n.HOOK.beforeToEdit = () => {
    console.log(t);
  }, n.HOOK.beforeSubmit = async () => {
    if (!await c.value.validate()) return false;
    t.type = u.query.type, t.childType = u.query.childType, t.year = u.query.year;
  }, (a, o) => {
    const i = f("common-button"), E = f("common-select-v2"), p = M, y = N, O = j, T = f("common-dialog"), q = U("show-thousand");
    return A(), R(T, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(r).cancelCU, visible: e(r).status.cu > 0, title: e(r).query.type === e(D).ELECTRIC_COST.V ? `${m.value ? "编辑" : "新增"}电费` : `${m.value ? "编辑" : "新增"}水费`, "show-close": false, width: "500px", top: "10vh" }, { titleRight: s(() => [h("span", F, [l(i, { loading: e(r).status.cu === e(n).STATUS.PROCESSING, size: "default", type: "primary", onClick: e(r).submitCU }, { default: s(() => o[3] || (o[3] = [g(" 提 交 ")])), _: 1, __: [3] }, 8, ["loading", "onClick"]), l(i, { size: "default", onClick: e(r).cancelCU }, { default: s(() => o[4] || (o[4] = [g("关 闭")])), _: 1, __: [4] }, 8, ["onClick"])])]), default: s(() => [h("div", H, [l(O, { ref_key: "formRef", ref: c, model: e(t), rules: x, size: "default", "label-width": "140px", class: "demo-form" }, { default: s(() => [l(p, { label: "月份：", prop: "month" }, { default: s(() => [l(E, { modelValue: e(t).month, "onUpdate:modelValue": o[0] || (o[0] = (d) => e(t).month = d), options: _.value, type: "other", placeholder: "请选择月份", "data-structure": { key: "id", label: "name", value: "id" }, class: "filter-item", clearable: "", style: { width: "270px" }, disabled: m.value }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), l(p, { label: "用量：", prop: "usedMete" }, { default: s(() => [S(l(y, { modelValue: e(t).usedMete, "onUpdate:modelValue": o[1] || (o[1] = (d) => e(t).usedMete = d), style: { width: "270px" }, placeholder: "输入用量", "controls-position": "right", min: 0, max: 9999999999 }, null, 8, ["modelValue"]), [[q]])]), _: 1 }), l(p, { label: "费用总额（元）：", prop: "totalAmount" }, { default: s(() => [l(y, { modelValue: e(t).totalAmount, "onUpdate:modelValue": o[2] || (o[2] = (d) => e(t).totalAmount = d), style: { width: "270px" }, placeholder: "输入费用总额", "controls-position": "right", precision: e(V).contract, min: 0, max: 9999999999 }, null, 8, ["modelValue", "precision"])]), _: 1 })]), _: 1 }, 8, ["model"])])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  P as default
};
