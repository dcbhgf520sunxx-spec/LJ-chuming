import { ref as f } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as A } from "vue";
import { createBlock as C } from "vue";
import { withCtx as s } from "vue";
import { createVNode as d } from "vue";
import { createTextVNode as b } from "vue";
import { toDisplayString as V } from "vue";
import { unref as u } from "vue";
import { isRef as I } from "vue";
import { ElNotification as x } from "element-plus";
import { ElTag as N } from "element-plus";
import { l as n, u as T, R as E, S as k } from "../../../../shared/runtime.js";
function B(t) {
  return n({ module: "contract", url: "project/listContracts", method: "get", params: t });
}
function U(t) {
  return n({ module: "contract", url: "project/getUnArchived", method: "get", params: t });
}
function D(t) {
  return n({ module: "contract", url: "project/isArchivist", method: "get", params: t });
}
function R({ projectId: t, fileIds: l }) {
  return n({ module: "contract", url: "project/appendAttachment", method: "post", data: { projectId: t, fileIds: l } });
}
function F(t) {
  return n({ module: "contract", url: "project/downloadAttachments", method: "post", responseType: "blob", data: t });
}
function z(t) {
  return n({ url: "/api/project/downloadAttachmentsNew", method: "post", responseType: "blob", data: t });
}
const G = { get: B }, S = { __name: "import-dialog", props: { visible: { type: Boolean, default: false }, isEdit: { type: Boolean, default: false }, projectInfo: { type: Object, default: () => ({}) } }, emits: ["update:visible", "success"], setup(t, { emit: l }) {
  const m = l, i = t, { visible: c, handleClose: p } = T({ emit: m, props: i, field: "visible", showHook: y }), a = f([]), h = f(false);
  function y() {
    var o;
    a.value = ((o = i.projectInfo) == null ? void 0 : o.attachmentFiles) || [];
  }
  async function j() {
    var o;
    try {
      h.value = true, await R({ projectId: (o = i.projectInfo) == null ? void 0 : o.id, fileIds: a.value.map((e) => e.id) || [] }), x({ title: "归档成功", type: "success", duration: 2e3 }), p(), m("success");
    } catch (e) {
      console.log(e);
    }
  }
  return (o, e) => {
    const v = g("common-button"), _ = N, w = g("common-dialog");
    return A(), C(w, { title: `附件导入【${t.projectInfo.name}】`, modelValue: u(c), "onUpdate:modelValue": e[1] || (e[1] = (r) => I(c) ? c.value = r : null), width: "640px", "before-close": u(p) }, { titleRight: s(() => [d(v, { type: "primary", size: "mini", onClick: j }, { default: s(() => [b(V(t.isEdit ? "确认修改附件" : "确认导入归档"), 1)]), _: 1 })]), default: s(() => [d(_, { type: "warning", style: { "margin-bottom": "10px" }, effect: "plain" }, { default: s(() => e[2] || (e[2] = [b("* 提示：导入的附件仅支持PDF、JPG、PNG格式")])), _: 1, __: [2] }), d(E, { showView: "", "show-download": "", accept: ".jpg,.png,.pdf,.jpeg", "file-classify": u(k).CONTRACT_ARCHIVES.V, files: a.value, "onUpdate:files": e[0] || (e[0] = (r) => a.value = r), "empty-text": "暂未上传附件" }, null, 8, ["file-classify", "files"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, H = Object.freeze(Object.defineProperty({ __proto__: null, default: S }, Symbol.toStringTag, { value: "Module" }));
export {
  S as _,
  D as a,
  F as b,
  G as c,
  z as d,
  U as g,
  H as i
};
