import { ref as v } from "vue";
import { watch as I } from "vue";
import { computed as A } from "vue";
import { useStore as C } from "vuex";
import { resolveComponent as P } from "vue";
import { openBlock as i } from "vue";
import { createBlock as p } from "vue";
import { withCtx as t } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as r } from "vue";
import { toDisplayString as f } from "vue";
import { unref as n } from "vue";
import { createCommentVNode as g } from "vue";
import { isRef as S } from "vue";
import { ElFormItem as z } from "element-plus";
import { ElInput as M } from "element-plus";
import { ElForm as k } from "element-plus";
import { _ as B, u as L, z as O, t1 as T, t2 as D, t0 as _ } from "../../../../../shared/runtime.js";
import G from "../../components/drawing-upload-btn/index.vue.js";
import "../../../../../modules/index-ce9deea8.js";
const H = { class: "project-name" }, U = { __name: "upload-form", props: { currentMonomer: { type: Object, default: () => {
} }, globalProject: { type: Object, default: () => {
} }, dataType: { type: [String, Number], default: void 0 }, modelValue: { type: Boolean, require: true }, currentRow: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(e, { emit: w }) {
  const a = e, o = v(JSON.parse(JSON.stringify({ fileName: void 0 }))), V = v(), h = { fileName: { required: true, message: "请输入文件命名", trigger: "blur" } }, N = w, { visible: s, handleClose: b } = L({ emit: N, props: a });
  I(() => s.value, (y) => {
    y && (o.value.fileName = void 0);
  }, { deep: true, immediate: true });
  const F = A(() => a.currentRow.id ? { id: a.currentRow.id, monomerId: a.currentMonomer.id, fileName: o.value.fileName } : { projectId: a.globalProject.id, monomerId: a.currentMonomer.id, dataType: a.dataType, fileName: o.value.fileName }), d = C();
  function R() {
    N("success"), d.dispatch("approval_list/fetchApprovalNum"), d.dispatch("approval_list/fetchSubNum", _.PLAN_CHANGE_FILE.V), d.dispatch("approval_list/fetchApprovalNum", _.PLAN_CHANGE_FILE.V), d.dispatch("approval_list/fetchRejNum", _.PLAN_CHANGE_FILE.V), b();
  }
  return (y, l) => {
    const u = z, j = M, x = k, E = P("common-dialog");
    return i(), p(E, { modelValue: n(s), "onUpdate:modelValue": l[1] || (l[1] = (c) => S(s) ? s.value = c : null), "before-close": n(b), "close-on-click-modal": false, title: e.currentRow.id ? "文件替换" : "文件上传", "append-to-body": "", width: "550px" }, { titleAfter: t(() => l[2] || (l[2] = [m("span", { style: { color: "red", "font-size": "12px" } }, "*导入格式为压缩包,文件类型仅支持DWG或PDF格式", -1)])), default: t(() => [r(x, { ref_key: "formRef", ref: V, model: o.value, rules: h, "label-width": "150px", size: "default" }, { default: t(() => [r(u, { label: "所属项目" }, { default: t(() => [m("span", H, f(n(O)(e.globalProject)), 1)]), _: 1 }), e.currentMonomer && e.currentMonomer.name ? (i(), p(u, { key: 0, label: "单体" }, { default: t(() => [m("span", null, f(e.currentMonomer.name), 1)]), _: 1 })) : g("", true), e.currentRow.id ? (i(), p(u, { key: 1, label: "原文件" }, { default: t(() => [m("span", null, f(e.currentRow.fileName), 1)]), _: 1 })) : g("", true), r(u, { label: "文件命名" }, { default: t(() => [r(j, { modelValue: o.value.fileName, "onUpdate:modelValue": l[0] || (l[0] = (c) => o.value.fileName = c), maxlength: 20, placeholder: "文件命名", style: { width: "320px" } }, null, 8, ["modelValue"])]), _: 1 }), r(u, { label: "上传" }, { default: t(() => [r(n(G), { ref: "changeFileRef", accept: ".zip", "btn-name": "文件上传", "btn-size": "mini", "btn-type": "warning", data: F.value, "data-type": e.dataType, icon: "el-icon-upload", "upload-fun": e.currentRow.id ? n(T) : n(D), class: "filter-item", "success-msg": "审批流已生成!请点击审批记录查看", tip: ".dwg,.pdf", onSuccess: R }, null, 8, ["data", "data-type", "upload-fun"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close", "title"]);
  };
} }, X = B(U, [["__scopeId", "data-v-58c9b8c4"]]);
export {
  X as default
};
