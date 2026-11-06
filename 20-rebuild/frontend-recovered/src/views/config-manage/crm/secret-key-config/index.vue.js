import { ref as d } from "vue";
import { computed as V } from "vue";
import { onMounted as B } from "vue";
import { resolveComponent as F } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as D } from "vue";
import { createVNode as t } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as l } from "vue";
import { unref as x } from "vue";
import { createBlock as N } from "vue";
import { createTextVNode as S } from "vue";
import { createCommentVNode as M } from "vue";
import { ElMessage as q } from "element-plus";
import { ElInput as z } from "element-plus";
import { ElFormItem as I } from "element-plus";
import { ElForm as K } from "element-plus";
import { ElCard as P } from "element-plus";
import { ElCol as j } from "element-plus";
import { ElRow as G } from "element-plus";
import { l as g, G as f, dF as _ } from "../../../../shared/runtime.js";
function R(n) {
  return g({ module: "crm", url: "enterpriseinquiries/config", method: "get", params: n });
}
function T(n) {
  return g({ module: "crm", url: "enterpriseinquiries/config", method: "post", data: n });
}
const U = { class: "app-container" }, A = { class: "clearfix" }, L = { __name: "index", setup(n) {
  const s = d({}), r = d({}), v = V(() => {
    let e = false;
    return s.value.appCode !== r.value.appCode ? e = false : e = true, e;
  }), c = d(false);
  B(() => {
    m();
  });
  async function m() {
    if (f(_.get)) try {
      const e = await R();
      console.log(e), e ? (s.value.appCode = "xxxxxxxxxxxxxxxxxx", r.value.appCode = "xxxxxxxxxxxxxxxxxx") : (s.value.appCode = void 0, r.value.appCode = void 0);
    } catch (e) {
      console.log(e);
    }
  }
  async function C() {
    try {
      c.value = true, await T(s.value), q.success("配置成功"), m();
    } catch (e) {
      console.log(e, "提交保存");
    } finally {
      c.value = false;
    }
  }
  return (e, a) => {
    const b = F("common-button"), y = z, u = I, w = K, h = P, i = j, k = G;
    return p(), D("div", U, [t(k, { gutter: 20 }, { default: o(() => [t(i, { xs: 24, sm: 24, md: 12, lg: 8 }, { default: o(() => [t(h, null, { header: o(() => [l("div", A, [a[2] || (a[2] = l("span", { class: "card-title" }, "密钥设置", -1)), x(f)(x(_).save) ? (p(), N(b, { key: 0, disabled: v.value, style: { float: "right", "margin-left": "8px" }, type: "success", size: "default", loading: c.value, onClick: C }, { default: o(() => a[1] || (a[1] = [S("保存")])), _: 1, __: [1] }, 8, ["disabled", "loading"])) : M("", true)])]), default: o(() => [t(w, { "label-width": "60px", model: s.value }, { default: o(() => [t(u, { label: "密钥" }, { default: o(() => [t(y, { style: { width: "60%" }, modelValue: s.value.appCode, "onUpdate:modelValue": a[0] || (a[0] = (E) => s.value.appCode = E), autocomplete: "new-password", type: "password" }, null, 8, ["modelValue"])]), _: 1 }), t(u, { "label-width": "0" }, { default: o(() => a[3] || (a[3] = [l("span", { class: "form-item-tip" }, " 提示说明： ", -1), l("span", { class: "form-item-tip" }, " 从第三方平台获取查询工商信息平台密钥； ", -1), l("span", { class: "form-item-tip" }, " 充值链接：https://market.aliyun.com/apimarket/detail/cmapi00064569 ", -1)])), _: 1, __: [3] })]), _: 1 }, 8, ["model"])]), _: 1 })]), _: 1 }), t(i, { xs: 24, sm: 24, md: 12, lg: 8 }), t(i, { xs: 24, sm: 24, md: 12, lg: 8 })]), _: 1 })]);
  };
} };
export {
  L as default
};
