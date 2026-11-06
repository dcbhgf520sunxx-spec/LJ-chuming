import { ref as r } from "vue";
import { computed as Q } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as w } from "vue";
import { createVNode as e } from "vue";
import { withCtx as i } from "vue";
import { unref as n } from "vue";
import { createTextVNode as y } from "vue";
import { withDirectives as W } from "vue";
import { createBlock as x } from "vue";
import { toDisplayString as C } from "vue";
import { createCommentVNode as X } from "vue";
import { Fragment as D } from "vue";
import { renderList as Y } from "vue";
import { createElementVNode as Z } from "vue";
import { isRef as ee } from "vue";
import { ElTableColumn as te } from "element-plus";
import { ElTag as oe } from "element-plus";
import { ElPagination as ae } from "element-plus";
import { vLoading as ne } from "element-plus";
import { a as le, b as ie, _ as re } from "./import-dialog.vue.js";
import { u as se, J as ce, o as pe, L as de, iE as V } from "../../../../shared/runtime.js";
const ue = ["onClick"], ge = { __name: "detail", props: { currentInfo: { type: Object, default: () => {
} }, modelValue: { type: Boolean, require: true } }, emits: ["update:modelValue"], setup(k, { emit: T }) {
  const _ = k, j = r([["importDate", ["parse-time", "{y}-{m}-{d}"]]]), z = T, v = r([]), u = r(false), m = r([]), f = r(false), b = r({}), I = Q(() => m.value.map((o) => o.id)), { visible: p, handleClose: L } = se({ emit: z, props: _, showHook: h }), { handleSizeChange: S, handleCurrentChange: B, total: E, setTotalPage: N, queryPage: d } = ce({ fetchHook: h }), R = r(), { maxHeight: P } = pe({ mainBox: ".contract-record-detail-drawer", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true }, p);
  async function h() {
    try {
      u.value = true;
      const { content: o = [], totalElements: l } = await le({ projectId: _.currentInfo.id, isArchivist: 1, ...d });
      v.value = o, N(l);
    } catch (o) {
      console.log(o);
    } finally {
      u.value = false;
    }
  }
  function A() {
    d.pageNumber = 1, h();
  }
  function H(o) {
    m.value = o;
  }
  function O(o) {
    window.open(o);
  }
  function $(o) {
    o.attachmentFiles = o.projectAttachmentDTOList, b.value = o, f.value = true;
  }
  return (o, l) => {
    const a = te, q = oe, F = g("common-button"), U = g("common-table"), J = ae, M = g("common-drawer"), G = ne;
    return c(), w(D, null, [e(M, { "append-to-body": "", ref_key: "drawerRef", ref: R, modelValue: n(p), "onUpdate:modelValue": l[0] || (l[0] = (t) => ee(p) ? p.value = t : null), top: "10vh", width: "600px", "before-close": n(L), title: "项目合同文档列表", "wrapper-closable": false, size: "70%", "custom-class": "contract-record-detail-drawer" }, { titleRight: i(() => {
      var t;
      return [e(de, { params: I.value, fn: n(ie), disabled: !((t = m.value) != null && t.length) }, { default: i(() => l[2] || (l[2] = [y(" 附件批量下载 ")])), _: 1, __: [2] }, 8, ["params", "fn", "disabled"])];
    }), content: i(() => [W((c(), x(U, { ref: "tableRef", data: v.value, "data-format": j.value, "max-height": n(P), style: { width: "100%" }, onSelectionChange: H }, { default: i(() => [e(a, { type: "selection", width: "55", align: "center" }), e(a, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(a, { prop: "contractDefinitionType", "show-overflow-tooltip": true, label: "合同类型", align: "center", width: "100px" }, { default: i(({ row: { sourceRow: t } }) => [t.contractDefinitionType ? (c(), x(q, { key: 0, effect: "plain", type: n(V).V[t.contractDefinitionType].T }, { default: i(() => [y(C(n(V).VL[t.contractDefinitionType]), 1)]), _: 2 }, 1032, ["type"])) : X("", true)]), _: 1 }), e(a, { prop: "serialNumber", "show-overflow-tooltip": true, label: "合同编号", align: "center", "min-width": "120px" }), e(a, { prop: "name", "show-overflow-tooltip": true, label: "合同名称", align: "center", "min-width": "120px" }), e(a, { prop: "firstParty", "show-overflow-tooltip": true, label: "甲方", align: "center", "min-width": "120px" }), e(a, { prop: "secondParty", "show-overflow-tooltip": true, label: "乙方", align: "center", "min-width": "120px" }), e(a, { prop: "contractArchivistName", "show-overflow-tooltip": true, label: "合同归档人", align: "center", width: "120px" }), e(a, { prop: "importDate", "show-overflow-tooltip": true, label: "归档日期", align: "center", width: "110px" }), e(a, { "show-overflow-tooltip": true, label: "附件", "min-width": "160px", "header-align": "center" }, { default: i(({ row: { sourceRow: t } }) => [(c(true), w(D, null, Y(t.projectAttachmentDTOList, (s) => (c(), w("div", { key: s.id, class: "ellipsis-text" }, [Z("span", { class: "tc-primary pointer", onClick: (K) => O(s.filePath) }, C(s.name), 9, ue)]))), 128))]), _: 1 }), e(a, { label: "操作", width: "80", align: "center" }, { default: i(({ row: { sourceRow: t } }) => {
      var s;
      return [e(F, { type: "primary", disabled: !((s = t.projectAttachmentDTOList) != null && s.length), icon: "el-icon-edit", size: "small", onClick: (K) => $(t) }, null, 8, ["disabled", "onClick"])];
    }), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[G, u.value]]), e(J, { total: n(E), "current-page": n(d).pageNumber, "page-size": n(d).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: n(S), onCurrentChange: n(B) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]), e(re, { visible: f.value, "onUpdate:visible": l[1] || (l[1] = (t) => f.value = t), isEdit: "", projectInfo: b.value, onSuccess: A }, null, 8, ["visible", "projectInfo"])], 64);
  };
} };
export {
  ge as default
};
