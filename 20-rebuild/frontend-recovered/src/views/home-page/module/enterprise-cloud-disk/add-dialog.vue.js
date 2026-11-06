import { ref as c } from "vue";
import { watchEffect as h } from "vue";
import { watch as F } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as I } from "vue";
import { createBlock as N } from "vue";
import { withCtx as l } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as _ } from "vue";
import { unref as n } from "vue";
import { createElementVNode as g } from "vue";
import { toDisplayString as U } from "vue";
import { isRef as R } from "vue";
import { ElNotification as H } from "element-plus";
import { ElFormItem as L } from "element-plus";
import { ElDatePicker as B } from "element-plus";
import { ElForm as q } from "element-plus";
import { c as z } from "../../../../modules/enterprise-cloud-disk-7c8bf938.js";
import { m as M, u as P, W as Y, R as O, S } from "../../../../shared/runtime.js";
const G = { __name: "add-dialog", props: { modelValue: { type: Boolean, default: false } }, emits: ["update:modelValue", "add-success"], setup(V, { emit: b }) {
  const { user: f } = M("user"), w = V, v = b, { visible: i, handleClose: m } = P({ emit: v, props: w }), u = c(), a = c({}), d = c(false), C = { createUserName: [{ required: true, message: "请输入用户名", trigger: "blur" }], sysHomeFileType: [{ required: true, message: "请选择文件类型", trigger: "change" }], informantDateTime: [{ required: true, message: "请选择日期", trigger: "change" }], attachmentIds: [{ required: true, message: "请导入内容", trigger: "change" }] };
  h(() => {
    a.value.createUserId = f.value.id, a.value.createUserName = f.value.name;
  }), F(() => {
    var s;
    return (s = a.value) == null ? void 0 : s.attachmentIds;
  }, (s) => {
    u.value.validateField("attachmentIds");
  }, { deep: true });
  async function x() {
    if (await u.value.validate()) try {
      d.value = true, await z(a.value), H({ title: "企业网盘存入成功", type: "success", duration: 2500 }), m(), v("add-success"), a.value = {};
    } catch (e) {
      console.log(e);
    } finally {
      d.value = false;
    }
  }
  return (s, e) => {
    const y = p("common-button"), r = L, D = p("common-select"), k = B, E = q, T = p("common-dialog");
    return I(), N(T, { modelValue: n(i), "onUpdate:modelValue": e[3] || (e[3] = (o) => R(i) ? i.value = o : null), "before-close": n(m), title: "企业网盘创建", width: "650px", showClose: false, "close-on-click-modal": false, "destroy-on-close": "" }, { titleRight: l(() => [t(y, { type: "primary", size: "mini", onClick: x, Loading: d.value }, { default: l(() => e[4] || (e[4] = [_("保存")])), _: 1, __: [4] }, 8, ["Loading"]), t(y, { onClick: n(m), size: "mini", plain: "" }, { default: l(() => e[5] || (e[5] = [_("取消")])), _: 1, __: [5] }, 8, ["onClick"])]), default: l(() => [t(E, { ref_key: "formRef", ref: u, "label-width": "90px", model: a.value, rules: C }, { default: l(() => [t(r, { label: "创建人", prop: "createUserName" }, { default: l(() => [g("span", null, U(a.value.createUserName), 1)]), _: 1 }), t(r, { label: "文件类型", prop: "sysHomeFileType" }, { default: l(() => [t(D, { modelValue: a.value.sysHomeFileType, "onUpdate:modelValue": e[0] || (e[0] = (o) => a.value.sysHomeFileType = o), options: n(Y).ENUM, type: "enum", clearable: "", placeholder: "请选择文件类型", style: { width: "100%" } }, null, 8, ["modelValue", "options"])]), _: 1 }), t(r, { label: "日期", prop: "informantDateTime" }, { default: l(() => [t(k, { modelValue: a.value.informantDateTime, "onUpdate:modelValue": e[1] || (e[1] = (o) => a.value.informantDateTime = o), format: "YYYY-MM-DD HH:mm", type: "datetime", "value-format": "x", placeholder: "请选择日期", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 }), t(r, { label: "内容", prop: "attachmentIds" }, { default: l(() => [t(O, { files: a.value.attachmentIds, "onUpdate:files": e[2] || (e[2] = (o) => a.value.attachmentIds = o), "file-classify": n(S).NORMAL.V, "empty-text": "暂未上传文件", "show-download": "", accept: ".pdf,.excel,.doc,.docx,.ppt,.pptx" }, null, 8, ["files", "file-classify"]), e[6] || (e[6] = g("span", { style: { color: "#F56C6C", "font-size": "12px" } }, "*仅支持WORD\\EXCEL\\PDF\\PPT格式", -1))]), _: 1, __: [6] })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  G as default
};
