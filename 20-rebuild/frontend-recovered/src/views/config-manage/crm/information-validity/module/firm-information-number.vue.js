import { ref as a } from "vue";
import { computed as D } from "vue";
import { onMounted as N } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as p } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as n } from "vue";
import { toDisplayString as k } from "vue";
import { unref as g } from "vue";
import { createTextVNode as M } from "vue";
import { createCommentVNode as R } from "vue";
import { createVNode as l } from "vue";
import { ElMessage as F } from "element-plus";
import { ElFormItem as I } from "element-plus";
import { ElForm as L } from "element-plus";
import { ElCard as S } from "element-plus";
import { G as v, dy as U } from "../../../../../shared/runtime.js";
import { c as j, e as z } from "../../../../../modules/information-validity-6783e35a.js";
const O = { class: "clearfix" }, T = { class: "card-title" }, Y = { __name: "firm-information-number", props: { permission: { type: Object, default: () => {
} } }, setup(r) {
  const b = r, m = a(), o = a({}), u = a({}), y = D(() => {
    let e = false;
    return o.value.times !== u.value.times ? e = false : e = true, e;
  }), i = a(false);
  N(() => {
    c();
  });
  const C = { times: [{ required: true, message: "查询上限（系统上限）", trigger: "change" }] };
  async function c() {
    if (v(b.permission.getBusinessLimitConfig)) try {
      const e = await j();
      console.log(e), o.value.times = e, u.value.times = e;
    } catch (e) {
      console.log(e);
    }
  }
  async function h() {
    if (await m.value.validate()) try {
      i.value = true, await z(o.value), F.success("配置成功"), c();
    } catch (t) {
      console.log(t, "提交保存");
    } finally {
      i.value = false;
    }
  }
  return (e, t) => {
    const x = d("common-button"), E = d("common-input-number"), f = I, V = L, w = S;
    return p(), _(w, null, { header: s(() => [n("div", O, [n("span", T, k(g(U).INDUSTRY_COMMERCE_NUMBER.L), 1), g(v)(r.permission.editBusinessLimitConfig) ? (p(), _(x, { key: 0, disabled: y.value, style: { float: "right", "margin-left": "8px" }, type: "success", size: "default", loading: i.value, onClick: h }, { default: s(() => t[1] || (t[1] = [M("保存")])), _: 1, __: [1] }, 8, ["disabled", "loading"])) : R("", true)])]), default: s(() => [l(V, { ref_key: "formRef", ref: m, model: o.value, rules: C, "label-width": "170px" }, { default: s(() => [l(f, { prop: "times", label: "查询上限（系统上限）" }, { default: s(() => [l(E, { "controls-position": "right", style: { width: "200px" }, min: 1, max: 99999, modelValue: o.value.times, "onUpdate:modelValue": t[0] || (t[0] = (B) => o.value.times = B) }, null, 8, ["modelValue"])]), _: 1 }), l(f, { "label-width": "0" }, { default: s(() => t[2] || (t[2] = [n("span", { class: "form-item-tip" }, " 配置说明： ", -1), n("span", { class: "form-item-tip" }, " 企业备案中三方付费查询工商信息：系统每日最多设置查询次数； ", -1)])), _: 1, __: [2] })]), _: 1 }, 8, ["model"])]), _: 1 });
  };
} };
export {
  Y as default
};
