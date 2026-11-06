import { ref as b } from "vue";
import { computed as I } from "vue";
import { watchEffect as U } from "vue";
import { onMounted as L } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as O } from "vue";
import { createBlock as R } from "vue";
import { withCtx as l } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { createTextVNode as T } from "vue";
import { ElFormItem as C } from "element-plus";
import { ElInput as P } from "element-plus";
import { ElInputNumber as F } from "element-plus";
import { ElForm as K } from "element-plus";
import { g as N } from "../../../../../../modules/production-line-c52339bd.js";
import { _ as q, ao as A, a3 as i } from "../../../../../../shared/runtime.js";
const S = { __name: "form", props: { workshopList: Array }, setup(y) {
  const p = b(), h = { id: void 0, workshopId: void 0, productType: void 0, ton: void 0, targetProduction: void 0, name: void 0, remark: "" }, c = b([]), { crud: r, CRUD: u, form: o } = A(h, p), w = I(() => r.status.edit >= 1), k = { workshopId: [{ required: true, message: "请选择车间", trigger: "change" }], productType: [{ required: true, message: "请选择产品类型", trigger: "change" }], name: [{ required: true, message: "长度在 1 到 32 个字符", trigger: "change" }, { min: 1, max: 32, message: "长度在 1 到 32 个字符", trigger: "change" }], ton: [{ required: true, message: "请填写目标产量", trigger: "change", type: "number" }], remark: [{ max: 500, message: "不能超过 500 个字符", trigger: "change" }] };
  U(() => {
    o.targetProduction = o.ton * 1e3;
  }), L(() => {
    f();
  });
  async function f() {
    c.value = [];
    try {
      const s = await N({});
      s == null || s.forEach((t) => {
        c.value.push({ name: t });
      });
    } catch (s) {
      console.log("获取所有生产线失败", s);
    }
  }
  return u.HOOK.beforeSubmit = async () => {
    o.mesProductEnum = r.query.mesProductEnum;
  }, u.HOOK.afterSubmit = async () => {
    f();
  }, u.HOOK.beforeToEdit = () => {
    o.ton = o.targetProductionShow;
  }, (s, t) => {
    const x = m("common-button"), _ = m("common-select"), d = C, g = P, V = F, E = K, v = m("common-dialog");
    return O(), R(v, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(r).cancelCU, visible: e(r).status.cu > 0, title: e(r).status.title, width: "550px" }, { titleRight: l(() => [n(x, { loading: e(r).status.cu === 2, type: "primary", size: "default", onClick: e(r).submitCU }, { default: l(() => t[5] || (t[5] = [T("确认")])), _: 1, __: [5] }, 8, ["loading", "onClick"])]), default: l(() => [n(E, { ref_key: "formRef", ref: p, model: e(o), rules: k, size: "default", "label-width": "130px" }, { default: l(() => [n(d, { label: "车间", prop: "workshopId" }, { default: l(() => [n(_, { modelValue: e(o).workshopId, "onUpdate:modelValue": t[0] || (t[0] = (a) => e(o).workshopId = a), disabled: w.value, options: y.workshopList, type: "other", "data-structure": { key: "id", label: "name", value: "id" }, class: "filter-item", clearable: "", style: { width: "270px" }, placeholder: "选择车间搜索" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), n(d, { label: "生产线名称", prop: "name" }, { default: l(() => [n(g, { modelValue: e(o).name, "onUpdate:modelValue": t[1] || (t[1] = (a) => e(o).name = a), placeholder: "请输入产线名称", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), n(d, { label: "目标产量(吨/月)", prop: "ton" }, { default: l(() => [n(V, { controls: false, modelValue: e(o).ton, "onUpdate:modelValue": t[2] || (t[2] = (a) => e(o).ton = a), modelModifiers: { number: true }, min: 0, max: 999999999, "controls-position": "right", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), n(d, { label: "产品类型", prop: "productType" }, { default: l(() => [n(_, { dataStructure: { key: "K", label: "L", value: "V" }, modelValue: e(o).productType, "onUpdate:modelValue": t[3] || (t[3] = (a) => e(o).productType = a), options: e(i).ENUM, unshowOptions: [e(i).ENCLOSURE.K, e(i).AUXILIARY_MATERIAL.K], placeholder: "请选择产品类型", style: { width: "270px" } }, null, 8, ["modelValue", "options", "unshowOptions"])]), _: 1 }), n(d, { label: "备注", prop: "remark" }, { default: l(() => [n(g, { modelValue: e(o).remark, "onUpdate:modelValue": t[4] || (t[4] = (a) => e(o).remark = a), type: "textarea", autosize: { minRows: 4, maxRows: 6 }, placeholder: "请填写备注", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, H = q(S, [["__scopeId", "data-v-5e74bed0"]]);
export {
  H as default
};
