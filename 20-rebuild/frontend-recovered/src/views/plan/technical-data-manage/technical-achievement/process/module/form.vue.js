import { ref as p } from "vue";
import { useStore as H } from "vuex";
import { ElMessage as S } from "element-plus";
import { resolveComponent as g } from "vue";
import { openBlock as b } from "vue";
import { createBlock as y } from "vue";
import { withCtx as i } from "vue";
import { createVNode as o } from "vue";
import { unref as a } from "vue";
import { createTextVNode as $ } from "vue";
import { createCommentVNode as E } from "vue";
import { createElementVNode as q } from "vue";
import { toDisplayString as K } from "vue";
import { ElFormItem as W } from "element-plus";
import { ElTableColumn as G } from "element-plus";
import { ElInput as J } from "element-plus";
import { ElForm as Q } from "element-plus";
import { _ as X, tt as R, ts as T, ao as Y, o as Z, fK as U, t0 as h, bb as ee, S as te, iy as le } from "../../../../../../shared/runtime.js";
import { _ as ae } from "../../../../../../modules/UploadBtn-b4cfb47a.js";
const oe = ["onClick"], re = { __name: "form", setup(se) {
  const v = p(), V = p(), N = p(), c = p(false), C = p(), j = { boolSingleProject: R.NORMAL.V, processType: T.WELD.V, projectId: void 0, fileList: [] }, _ = H(), { CRUD: w, crud: d, form: s } = Y(j, v), { maxHeight: L } = Z({ mainBox: ".delivery-detail", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, V), P = { boolSingleProject: { required: true, message: "请选择文件类型", trigger: "change" }, processType: { required: true, message: "请选择工艺类型", trigger: "change" }, projectId: { required: true, message: "请选择所属项目", trigger: "change" }, fileList: { required: true, message: "请上传文件", trigger: "change" } }, x = { fileName: [{ validator: (t, e) => !(!t || t.length > 50), message: "请填写文件名", trigger: ["blur", "change"] }] };
  function F({ row: t, column: e }) {
    if (!t) return;
    const n = x;
    let r = true;
    return t.verify && Object.keys(t.verify) && Object.keys(t.verify).length > 0 && (t.verify[e.property] === false && (r = U(e.property, n[e.property], t)), r && (t.verify[e.property] = true)), r ? "" : "mask-td";
  }
  function M(t) {
    s.fileList.splice(t, 1);
  }
  w.HOOK.beforeSubmit = (t, e) => {
    if (t.form.fileList.length <= 0) return S({ message: "请上传文件", type: "error" }), false;
    const n = x;
    let r = true;
    if (t.form.fileList.map((f) => {
      f.verify = {};
      for (const m in n) f.verify[m] = U(m, n[m], f), f.verify[m] || (r = false);
    }), !r) return S.error("文件名称必填且长度不超过50字符"), false;
  };
  function O(t) {
    C.value = t.attachmentId, c.value = true;
  }
  function I() {
    d.submitCU();
  }
  w.HOOK.afterSubmit = (t, e) => {
    _.dispatch("approval_list/fetchApprovalNum"), _.dispatch("approval_list/fetchSubNum", h.PLAN_PROCESS_DOCUMENT.V), _.dispatch("approval_list/fetchApprovalNum", h.PLAN_PROCESS_DOCUMENT.V), _.dispatch("approval_list/fetchRejNum", h.PLAN_PROCESS_DOCUMENT.V);
  };
  function A() {
    const t = d.form.attachmentFiles[0].name, e = t.split(".");
    let n = "";
    for (let r = 0; r < e.length; r++) r !== e.length - 1 && (r !== e.length - 2 ? n = n + e[r] + "." : n = n + e[r]);
    d.form.fileList.push({ attachmentId: d.form.attachmentFiles[0].id, fileName: n, file: t, remark: void 0 }), N.value.clearFiles(), s.attachmentFiles = [];
  }
  return (t, e) => {
    const n = g("common-button"), r = g("common-radio"), f = W, m = G, k = J, z = g("common-table"), B = Q, D = g("common-drawer");
    return b(), y(D, { ref_key: "drawerRef", ref: V, "before-close": a(d).cancelCU, "close-on-click-modal": false, "show-close": true, visible: a(d).status.cu > 0, "wrapper-closable": false, "custom-class": "delivery-detail", size: "60%", title: "上传工艺文件" }, { titleRight: i(() => [o(n, { loading: a(d).status.cu === 2, size: "default", type: "primary", onClick: I }, { default: i(() => e[5] || (e[5] = [$(" 提交 ")])), _: 1, __: [5] }, 8, ["loading"])]), content: i(() => [o(B, { ref_key: "formRef", ref: v, model: a(s), rules: P, "label-width": "100px", size: "default" }, { default: i(() => [o(f, { label: "工艺类型", prop: "processType" }, { default: i(() => [o(r, { modelValue: a(s).processType, "onUpdate:modelValue": e[0] || (e[0] = (l) => a(s).processType = l), options: a(T).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), o(f, { label: "文件类型", prop: "boolSingleProject" }, { default: i(() => [o(r, { modelValue: a(s).boolSingleProject, "onUpdate:modelValue": e[1] || (e[1] = (l) => a(s).boolSingleProject = l), options: a(R).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), a(s).boolSingleProject ? (b(), y(f, { key: 0, label: "所属项目", prop: "projectId" }, { default: i(() => [o(ee, { modelValue: a(s).projectId, "onUpdate:modelValue": e[2] || (e[2] = (l) => a(s).projectId = l), clearable: "", placeholder: "项目搜索", style: { width: "270px", "margin-bottom": "10px" } }, null, 8, ["modelValue"])]), _: 1 })) : E("", true), o(f, { label: "上传文件", prop: "fileList" }, { default: i(() => [o(a(ae), { ref_key: "uploadRef", ref: N, files: a(s).attachmentFiles, "onUpdate:files": e[3] || (e[3] = (l) => a(s).attachmentFiles = l), accept: ".pdf", "file-classify": a(te).PLAN_ATT.V, limit: 1, "show-file-list": false, btnType: "warning", onChange: A }, null, 8, ["files", "file-classify"])]), _: 1 }), o(z, { ref: "detailRef", "cell-class-name": F, data: a(s).fileList, "max-height": a(L) - 200, showEmptySymbol: false, border: "", class: "table-form", "return-source-data": "", style: { width: "100%" } }, { default: i(() => [o(m, { align: "center", label: "序号", type: "index", width: "55" }), o(m, { align: "left", label: "文件", prop: "file" }, { default: i((l) => [q("span", { style: { cursor: "pointer", color: "#409eff" }, onClick: (u) => O(l.row) }, K(l.row.file), 9, oe)]), _: 1 }), o(m, { align: "center", label: "名称", prop: "fileName" }, { default: i((l) => [o(k, { modelValue: l.row.fileName, "onUpdate:modelValue": (u) => l.row.fileName = u, modelModifiers: { trim: true }, maxlength: 50, autosize: "", class: "input-border-none", clearable: "", placeholder: "名称", style: { width: "100%" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), o(m, { align: "center", label: "备注", prop: "remark" }, { default: i((l) => [o(k, { modelValue: l.row.remark, "onUpdate:modelValue": (u) => l.row.remark = u, modelModifiers: { trim: true }, maxlength: 200, autosize: "", class: "input-border-none", placeholder: "备注", style: { width: "100%" }, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), o(m, { align: "center", label: "操作", width: "80" }, { default: i((l) => [o(n, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (u) => M(l.$index) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["model"]), c.value ? (b(), y(le, { key: 0, id: C.value, isVisible: c.value, showType: "attachment", onClose: e[4] || (e[4] = (l) => c.value = false) }, null, 8, ["id", "isVisible"])) : E("", true)]), _: 1 }, 8, ["before-close", "visible"]);
  };
} }, de = X(re, [["__scopeId", "data-v-67d062eb"]]);
export {
  de as default
};
