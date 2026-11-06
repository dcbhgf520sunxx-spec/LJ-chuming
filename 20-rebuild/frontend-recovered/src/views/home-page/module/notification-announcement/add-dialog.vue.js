import { ref as y } from "vue";
import { watchEffect as F } from "vue";
import { watch as P } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as T } from "vue";
import { withCtx as s } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as w } from "vue";
import { unref as m } from "vue";
import { createElementVNode as u } from "vue";
import { toDisplayString as M } from "vue";
import { createElementBlock as k } from "vue";
import { createCommentVNode as C } from "vue";
import { isRef as z } from "vue";
import { ElNotification as B } from "element-plus";
import { ElFormItem as q } from "element-plus";
import { ElDatePicker as Y } from "element-plus";
import { ElInput as j } from "element-plus";
import { ElForm as G } from "element-plus";
import { c as A } from "../../../../modules/notification-announcement-a0e50fbd.js";
import { n as J, m as K, u as S, R as Q, S as W, V as X } from "../../../../shared/runtime.js";
const Z = { style: { width: "100%" } }, $ = { key: 0 }, ae = { __name: "add-dialog", props: { modelValue: { type: Boolean, default: false } }, emits: ["update:modelValue", "add-success"], setup(N, { emit: L }) {
  const l = { ONLINE_EDIT: { L: "在线编辑", K: "ONLINE_EDIT", V: 1 }, FILE_IMPORT: { L: "文件导入", K: "FILE_IMPORT", V: 2 } };
  J(l);
  const { user: g } = K("user"), h = N, V = L, { visible: d, handleClose: p } = S({ emit: V, props: h }), I = { sysHomeContentType: l.ONLINE_EDIT.V }, D = (i, e, n) => {
    var r;
    e ? (t.value.sysHomeContentType === l.ONLINE_EDIT.V && (t.value.content ? n() : n(new Error("请输入内容"))), t.value.sysHomeContentType === l.FILE_IMPORT.V && ((r = t.value.attachmentIds) != null && r.length ? n() : n(new Error("请上传文件"))), n()) : n(new Error("请选择内容类型"));
  }, f = y(), t = y({ ...I }), c = y(false), H = { createUserName: [{ required: true, message: "请输入用户名", trigger: "blur" }], informantDateTime: [{ required: true, message: "请选择日期", trigger: "change" }], title: [{ required: true, message: "请输入标题", trigger: "blur" }], sysHomeContentType: [{ required: true, message: "请选择内容类型", trigger: "change" }, { validator: D, message: "内容为空", trigger: ["blur", "change"] }] };
  F(() => {
    t.value.createUserId = g.value.id, t.value.createUserName = g.value.name;
  }), P(() => {
    var i;
    return (i = t.value) == null ? void 0 : i.attachmentIds;
  }, (i) => {
    f.value.validateField("sysHomeContentType");
  }, { deep: true });
  async function b() {
    if (await f.value.validate()) try {
      c.value = true;
      const e = X(t.value);
      e.sysHomeContentType === l.FILE_IMPORT.V && delete e.content, e.sysHomeContentType === l.ONLINE_EDIT.V && delete e.attachmentIds, await A(e), B({ title: "通知公告创建成功", type: "success", duration: 2500 }), p(), V("add-success"), t.value = { ...I };
    } catch (e) {
      console.log(e);
    } finally {
      c.value = false;
    }
  }
  return (i, e) => {
    const n = v("common-button"), r = q, x = Y, E = j, O = v("common-radio-button"), U = G, R = v("common-dialog");
    return _(), T(R, { modelValue: m(d), "onUpdate:modelValue": e[5] || (e[5] = (o) => z(d) ? d.value = o : null), "before-close": m(p), title: "通知公告创建", width: "650px", "close-on-click-modal": false, showClose: false, "destroy-on-close": "" }, { titleRight: s(() => [a(n, { type: "primary", size: "mini", onClick: b, Loading: c.value }, { default: s(() => e[6] || (e[6] = [w("保存")])), _: 1, __: [6] }, 8, ["Loading"]), a(n, { onClick: m(p), size: "mini", plain: "" }, { default: s(() => e[7] || (e[7] = [w("取消")])), _: 1, __: [7] }, 8, ["onClick"])]), default: s(() => [a(U, { ref_key: "formRef", ref: f, "label-width": "90px", model: t.value, rules: H }, { default: s(() => [a(r, { label: "创建人", prop: "createUserName" }, { default: s(() => [u("span", null, M(t.value.createUserName), 1)]), _: 1 }), a(r, { label: "日期", prop: "informantDateTime" }, { default: s(() => [a(x, { modelValue: t.value.informantDateTime, "onUpdate:modelValue": e[0] || (e[0] = (o) => t.value.informantDateTime = o), format: "YYYY-MM-DD HH:mm", type: "datetime", "value-format": "x", placeholder: "请选择日期", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 }), a(r, { label: "标题", prop: "title" }, { default: s(() => [a(E, { modelValue: t.value.title, "onUpdate:modelValue": e[1] || (e[1] = (o) => t.value.title = o), placeholder: "请输入标题，最多支持20个字符", maxlength: "20", "show-word-limit": "" }, null, 8, ["modelValue"])]), _: 1 }), a(r, { label: "内容", prop: "sysHomeContentType" }, { default: s(() => [a(O, { modelValue: t.value.sysHomeContentType, "onUpdate:modelValue": e[2] || (e[2] = (o) => t.value.sysHomeContentType = o), options: l.ENUM, size: "small", type: "enum", style: { "margin-bottom": "10px", width: "100%" } }, null, 8, ["modelValue", "options"]), u("div", Z, [t.value.sysHomeContentType === l.FILE_IMPORT.V ? (_(), k("div", $, [a(Q, { files: t.value.attachmentIds, "onUpdate:files": e[3] || (e[3] = (o) => t.value.attachmentIds = o), "file-classify": m(W).NORMAL.V, "empty-text": "暂未上传文件", "show-download": "", "show-view": "", accept: ".pdf,.jpg,.jpeg,.png" }, null, 8, ["files", "file-classify"]), e[8] || (e[8] = u("span", { style: { color: "#f56c6c", "font-size": "12px" } }, "*仅支持PDF\\PNC\\JPG\\JPEG格式", -1))])) : C("", true), u("div", null, [t.value.sysHomeContentType === l.ONLINE_EDIT.V ? (_(), T(E, { key: 0, modelValue: t.value.content, "onUpdate:modelValue": e[4] || (e[4] = (o) => t.value.content = o), type: "textarea", rows: 5, style: { width: "100%" }, placeholder: "请输入内容", maxlength: "10000", "show-word-limit": "" }, null, 8, ["modelValue"])) : C("", true)])])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  ae as default
};
