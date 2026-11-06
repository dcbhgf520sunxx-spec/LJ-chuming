import { computed as j } from "vue";
import { ref as i } from "vue";
import { watch as A } from "vue";
import { nextTick as D } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as J } from "vue";
import { createBlock as $ } from "vue";
import { withCtx as o } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as c } from "vue";
import { createElementVNode as G } from "vue";
import { toDisplayString as g } from "vue";
import { unref as m } from "vue";
import { isRef as K } from "vue";
import { ElTag as P } from "element-plus";
import { ElFormItem as Q } from "element-plus";
import { ElInput as W } from "element-plus";
import { ElForm as X } from "element-plus";
import { m as Y, n as Z } from "../../../../../modules/artifact-tree-bcd3b733.js";
import { _ as ee, u as te, o as ae, z as C } from "../../../../../shared/runtime.js";
import { _ as oe } from "../../../../../modules/change-reason-select-73e53277.js";
const le = { class: "content-header" }, re = { __name: "delete-table", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, query: { type: Object, default: () => {
} }, currentMonomer: { type: Object, default: () => {
} }, artifactIds: { type: Array, default: () => [] }, areaInfo: { type: Object, default: () => {
} }, projectInfo: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "success"], setup(n, { emit: O }) {
  const y = O, r = n, { visible: _, handleClose: T } = te({ emit: y, props: r }), z = j(() => r.artifactIds.length > 0 ? { artifactIds: r.artifactIds } : { artifactIds: [r.detailInfo.id] }), d = i(), v = i(false), s = i(JSON.parse(JSON.stringify({ changeReasonId: void 0, remark: void 0 }))), B = { changeReasonId: [{ required: true, message: "请选择变更原因", trigger: "change" }], remark: [{ required: true, max: 200, message: "不能超过 200 个字符", trigger: "blur" }] };
  A(_, (l) => {
    l && (q(), R());
  }, { immediate: true, deep: true });
  function q() {
    d.value && d.value.resetFields(), v.value = false, d.value && D(() => {
      d.value.clearValidate();
    });
  }
  const x = i(), h = i([]), I = i(), w = i(false), { maxHeight: F } = ae({ mainBox: ".artifact-tree-delete-table", extraBox: [".el-drawer__header", ".form", ".content-header"], wrapperBox: ".el-drawer__body", paginate: false, minHeight: 300, navbar: false, extraHeight: 40, clientHRepMainH: true }, () => I.value.loaded), k = j(() => {
    var l;
    return ((l = x.value) == null ? void 0 : l.getCheckboxRecords()) || [];
  });
  async function R(l) {
    let t = [];
    if (!r.detailInfo.id && !r.artifactIds.length) {
      h.value = t;
      return;
    }
    w.value = true;
    try {
      const { content: f = [] } = await Y({ ...z.value });
      t = f;
    } catch (f) {
      console.log("获取构件详情失败", f);
    } finally {
      h.value = t, w.value = false;
    }
  }
  async function H() {
    try {
      await d.value.validate(), v.value = true;
      const l = { monomerId: r.query.monomerId, areaId: r.query.areaId, changeReasonId: s.value.changeReasonId, remark: s.value.remark, changeScopeEnum: 1, delArtifactList: k.value.map((t) => ({ artifactId: t.artifactId, sortNumber: t.sortNumber })) };
      await Z(l), L();
    } catch (l) {
      console.log("修改构件信息", l);
    } finally {
      v.value = false;
    }
  }
  function L() {
    R(), y("success");
  }
  return (l, t) => {
    const f = b("common-button"), V = P, N = Q, S = W, E = X, u = b("vxe-column"), M = b("vxe-table"), U = b("common-drawer");
    return J(), $(U, { ref_key: "drawerRef", ref: I, title: `项目:${n.detailInfo.project ? m(C)(n.detailInfo.project) : m(C)(n.projectInfo)}`, "close-on-click-modal": false, modelValue: m(_), "onUpdate:modelValue": t[2] || (t[2] = (e) => K(_) ? _.value = e : null), direction: "rtl", "before-close": m(T), "custom-class": "artifact-tree-delete-table", size: "50%" }, { titleAfter: o(() => t[3] || (t[3] = [])), titleRight: o(() => [a(f, { type: "danger", onClick: H, disabled: k.value.length === 0, loading: v.value }, { default: o(() => t[4] || (t[4] = [c("批量删除")])), _: 1, __: [4] }, 8, ["disabled", "loading"])]), content: o(() => [G("div", le, [a(V, { effect: "plain", size: "large" }, { default: o(() => {
      var e;
      return [c("单体：" + g((e = n.currentMonomer) == null ? void 0 : e.name), 1)];
    }), _: 1 }), a(V, { effect: "plain", size: "large" }, { default: o(() => {
      var e, p;
      return [c("区域：" + g(((e = n.detailInfo.area) == null ? void 0 : e.name) || ((p = n.areaInfo) == null ? void 0 : p.name)), 1)];
    }), _: 1 })]), a(E, { class: "form", ref_key: "formRef", ref: d, model: s.value, rules: B, size: "default", "label-width": "100px" }, { default: o(() => [a(N, { label: "原因类型", prop: "changeReasonId" }, { default: o(() => [a(m(oe), { modelValue: s.value.changeReasonId, "onUpdate:modelValue": t[0] || (t[0] = (e) => s.value.changeReasonId = e), clearable: "" }, null, 8, ["modelValue"])]), _: 1 }), a(N, { label: "原因描述", prop: "remark" }, { default: o(() => [a(S, { modelValue: s.value.remark, "onUpdate:modelValue": t[1] || (t[1] = (e) => s.value.remark = e), modelModifiers: { trim: true }, type: "textarea", autosize: { minRows: 3, maxRows: 6 }, maxlength: 200, placeholder: "请填写原因描述", style: { width: "320px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"]), a(M, { border: "", "show-header-overflow": "", stripe: "", ref_key: "tableRef", ref: x, data: h.value, "max-height": m(F), loading: w.value, "loading-config": { text: "正在加载" }, "empty-text": "暂无数据", "column-config": { resizable: true }, "row-config": { isHover: true }, "return-source-data": "", "scroll-y": { enabled: true, scrollToTopOnChange: true, gt: 0 }, "scroll-x": { enabled: true, scrollToLeftOnChange: true, gt: 0 }, "show-overflow": "tooltip" }, { default: o(() => [a(u, { type: "checkbox", align: "center", width: "50", fixed: "left" }), a(u, { type: "seq", title: "序号", align: "center", width: "80" }), a(u, { key: "sortNumber", field: "sortNumber", "show-overflow-tooltip": "", title: "流水号", "min-width": "120" }, { default: o((e) => [c(g(e.row.sortNumber ? e.row.serialNumber + "(" + e.row.sortNumber + ")" : "-"), 1)]), _: 1 }), a(u, { key: "productionLine.name", field: "productionLine.name", "show-overflow-tooltip": "", title: "产线", align: "left", "min-width": "80px" }, { default: o((e) => {
      var p;
      return [c(g(((p = e.row.productionLine) == null ? void 0 : p.name) || "-"), 1)];
    }), _: 1 }), a(u, { key: "status", field: "status", "show-overflow-tooltip": "", title: "当前状态", align: "left", "min-width": "80px" }, { default: o((e) => [c(g(e.row.status ? e.row.status : "-"), 1)]), _: 1 }), a(u, { key: "importUserName", field: "importUserName", "show-overflow-tooltip": "", title: "导入人", align: "left", "min-width": "80px" })]), _: 1 }, 8, ["data", "max-height", "loading"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, ce = ee(re, [["__scopeId", "data-v-70724d05"]]);
export {
  ce as default
};
