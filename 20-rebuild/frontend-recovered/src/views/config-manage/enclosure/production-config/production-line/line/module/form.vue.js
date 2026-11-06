import { ref as u } from "vue";
import { computed as b } from "vue";
import { onMounted as R } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as U } from "vue";
import { createBlock as F } from "vue";
import { withCtx as r } from "vue";
import { createVNode as a } from "vue";
import { unref as o } from "vue";
import { createTextVNode as z } from "vue";
import { ElFormItem as q } from "element-plus";
import { ElInput as B } from "element-plus";
import { ElForm as K } from "element-plus";
import { _ as O, T as k, ao as S, dS as N, dT as A } from "../../../../../../../shared/runtime.js";
const D = { __name: "form", props: { productTypeList: { type: Array, default: () => [] } }, setup(h) {
  const p = u();
  u([k.STRUCTURE.K, k.BRIDGE.K]);
  const w = h, x = { id: void 0, type: void 0, workshopId: void 0, name: void 0, remark: "" }, c = u([]), { crud: s, CRUD: f, form: t } = S(x, p), I = b(() => s.status.edit >= 1), { workshops: V } = N(), v = b(() => V.value.filter((e) => e.type === 4)), L = { workshopId: [{ required: true, message: "请选择车间", trigger: "change" }], linkIdList: [{ required: true, message: "请选择可生产产品种类", trigger: "change" }], name: [{ required: true, message: "请填写或选择生产线名称", trigger: "blur" }, { min: 1, max: 32, message: "长度在 1 到 32 个字符", trigger: "blur" }], remark: [{ max: 500, message: "不能超过 500 个字符", trigger: "blur" }] };
  R(() => {
    _();
  });
  async function _() {
    c.value = [];
    try {
      const l = await A({});
      l == null || l.forEach((e) => {
        c.value.push({ name: e });
      });
    } catch (l) {
      console.log("获取所有生产线失败", l);
    }
  }
  function E(l) {
    let e;
    l && l.forEach((i) => {
      e |= i;
    }), t.type = e;
  }
  return f.HOOK.beforeSubmit = async () => {
    s.form.factoryId = s.query.factoryId;
  }, f.HOOK.afterSubmit = async () => {
    await _();
  }, (l, e) => {
    const i = m("common-button"), y = m("common-select"), d = q, g = B, T = K, C = m("common-dialog");
    return U(), F(C, { "before-close": o(s).cancelCU, "close-on-click-modal": false, title: o(s).status.title, visible: o(s).status.cu > 0, "append-to-body": "", width: "550px" }, { titleRight: r(() => [a(i, { loading: o(s).status.cu === 2, size: "default", type: "primary", onClick: o(s).submitCU }, { default: r(() => e[4] || (e[4] = [z("确认 ")])), _: 1, __: [4] }, 8, ["loading", "onClick"])]), default: r(() => [a(T, { ref_key: "formRef", ref: p, model: o(t), rules: L, "label-width": "130px", size: "default" }, { default: r(() => [a(d, { label: "车间", prop: "workshopId" }, { default: r(() => [a(y, { modelValue: o(t).workshopId, "onUpdate:modelValue": e[0] || (e[0] = (n) => o(t).workshopId = n), "data-structure": { key: "id", label: "name", value: "id" }, disabled: I.value, options: v.value, class: "filter-item", clearbale: "", placeholder: "选择车间搜索", style: { width: "270px" }, type: "other" }, null, 8, ["modelValue", "disabled", "options"])]), _: 1 }), a(d, { label: "生产线名称", prop: "name" }, { default: r(() => [a(g, { modelValue: o(t).name, "onUpdate:modelValue": e[1] || (e[1] = (n) => o(t).name = n), class: "filter-item", clearable: "", placeholder: "请填写生产线", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), a(d, { label: "可生产产品种类", prop: "linkIdList" }, { default: r(() => [a(y, { modelValue: o(t).linkIdList, "onUpdate:modelValue": e[2] || (e[2] = (n) => o(t).linkIdList = n), "data-structure": { key: "id", label: "label", value: "id" }, options: w.productTypeList, multiple: "", placeholder: "请选择可生产产品种类", size: "default", style: { width: "270px" }, type: "other", onChange: E }, null, 8, ["modelValue", "options"])]), _: 1 }), a(d, { label: "备注", prop: "remark" }, { default: r(() => [a(g, { modelValue: o(t).remark, "onUpdate:modelValue": e[3] || (e[3] = (n) => o(t).remark = n), autosize: { minRows: 4, maxRows: 6 }, placeholder: "请填写备注", style: { width: "320px" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "title", "visible"]);
  };
} }, j = O(D, [["__scopeId", "data-v-e6fa0992"]]);
export {
  j as default
};
