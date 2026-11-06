import { ref as c } from "vue";
import { watchEffect as k } from "vue";
import { watch as U } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as E } from "vue";
import { createBlock as R } from "vue";
import { withCtx as l } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as _ } from "vue";
import { unref as r } from "vue";
import { createElementVNode as y } from "vue";
import { toDisplayString as B } from "vue";
import { isRef as L } from "vue";
import { ElNotification as P } from "element-plus";
import { ElFormItem as T } from "element-plus";
import { ElDatePicker as q } from "element-plus";
import { ElInput as z } from "element-plus";
import { ElForm as F } from "element-plus";
import { c as Y } from "../../../../modules/company-dynamics-34941552.js";
import { m as j, u as G, R as M, S as H } from "../../../../shared/runtime.js";
const O = { __name: "add-dialog", props: { modelValue: { type: Boolean, default: false } }, emits: ["update:modelValue", "add-success"], setup(w, { emit: V }) {
  const { user: f } = j("user"), b = w, p = V, { visible: i, handleClose: m } = G({ emit: p, props: b }), u = c(), a = c({}), d = c(false), h = { createUserName: [{ required: true, message: "请输入用户名", trigger: "blur" }], informantDateTime: [{ required: true, message: "请选择日期", trigger: "change" }], title: [{ required: true, message: "请输入标题", trigger: "blur" }], attachmentIds: [{ required: true, message: "请导入内容", trigger: "change" }] };
  k(() => {
    a.value.createUserId = f.value.id, a.value.createUserName = f.value.name;
  }), U(() => {
    var s;
    return (s = a.value) == null ? void 0 : s.attachmentIds;
  }, (s) => {
    u.value.validateField("attachmentIds");
  }, { deep: true });
  async function C() {
    if (await u.value.validate()) try {
      d.value = true, await Y(a.value), m(), P({ title: "公司动态创建成功", type: "success", duration: 2500 }), p("add-success"), a.value = {};
    } catch (e) {
      console.log(e);
    } finally {
      d.value = false;
    }
  }
  return (s, e) => {
    const v = g("common-button"), n = T, I = q, x = z, D = F, N = g("common-dialog");
    return E(), R(N, { modelValue: r(i), "onUpdate:modelValue": e[3] || (e[3] = (o) => L(i) ? i.value = o : null), "before-close": r(m), title: "公司动态创建", width: "650px", "close-on-click-modal": false, showClose: false, "destroy-on-close": "" }, { titleRight: l(() => [t(v, { type: "primary", size: "mini", onClick: C, Loading: d.value }, { default: l(() => e[4] || (e[4] = [_("保存")])), _: 1, __: [4] }, 8, ["Loading"]), t(v, { onClick: r(m), size: "mini", plain: "" }, { default: l(() => e[5] || (e[5] = [_("取消")])), _: 1, __: [5] }, 8, ["onClick"])]), default: l(() => [t(D, { ref_key: "formRef", ref: u, "label-width": "90px", model: a.value, rules: h }, { default: l(() => [t(n, { label: "创建人", prop: "createUserName" }, { default: l(() => [y("span", null, B(a.value.createUserName), 1)]), _: 1 }), t(n, { label: "日期", prop: "informantDateTime" }, { default: l(() => [t(I, { modelValue: a.value.informantDateTime, "onUpdate:modelValue": e[0] || (e[0] = (o) => a.value.informantDateTime = o), format: "YYYY-MM-DD HH:mm", type: "datetime", "value-format": "x", placeholder: "请选择日期", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 }), t(n, { label: "标题", prop: "title" }, { default: l(() => [t(x, { modelValue: a.value.title, "onUpdate:modelValue": e[1] || (e[1] = (o) => a.value.title = o), placeholder: "请输入标题，最多支持20个字符", maxlength: "20", "show-word-limit": "" }, null, 8, ["modelValue"])]), _: 1 }), t(n, { label: "内容", prop: "attachmentIds" }, { default: l(() => [t(M, { files: a.value.attachmentIds, "onUpdate:files": e[2] || (e[2] = (o) => a.value.attachmentIds = o), "file-classify": r(H).NORMAL.V, "empty-text": "暂未上传文件", "show-download": "", "show-view": "", accept: ".pdf,.jpg,.jpeg,.png" }, null, 8, ["files", "file-classify"]), e[6] || (e[6] = y("span", { style: { color: "#f56c6c", "font-size": "12px" } }, "*仅支持PDF\\PNC\\JPG\\JPEG格式", -1))]), _: 1, __: [6] })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  O as default
};
