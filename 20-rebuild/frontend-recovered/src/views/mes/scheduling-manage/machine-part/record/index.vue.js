import { ref as f } from "vue";
import { resolveComponent as T } from "vue";
import { resolveDirective as z } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as b } from "vue";
import { createElementVNode as H } from "vue";
import { createVNode as d } from "vue";
import { withCtx as c } from "vue";
import { withDirectives as y } from "vue";
import { createBlock as l } from "vue";
import { unref as e } from "vue";
import { createTextVNode as v } from "vue";
import { createCommentVNode as i } from "vue";
import { toDisplayString as w } from "vue";
import { Fragment as M } from "vue";
import { ElMessage as $ } from "element-plus";
import { ElNotification as F } from "element-plus";
import { ElTableColumn as A } from "element-plus";
import { ElTag as Q } from "element-plus";
import { vLoading as j } from "element-plus";
import { x as K, rz as g, rA as J, rB as X, o as Y, cb as m, az as Z, G as ee, an as te, P as ae, aw as oe, rC as le } from "../../../../../shared/runtime.js";
import ie from "./module/header.vue.js";
import se from "./module/record-detail.vue.js";
import { _ as ne } from "../../../../../modules/cut-config-select-6e1b2706.js";
const re = { class: "app-container" }, ue = { class: "head-container" }, ce = { key: 1 }, _e = { __name: "index", setup(de) {
  const x = { add: false, edit: false, del: true, download: false }, k = f(), { crud: n, columns: r, CRUD: I } = K({ title: "预览记录", sort: [], permission: { ...g }, optShow: { ...x }, crudApi: { get: J, del: X } }, k), R = f([["askCompleteTime", ["parse-time", "{y}-{m}-{d}"]]]), { maxHeight: D } = Y({ paginate: true }), h = f(false), N = f(), _ = f(false), O = { cutConfigId: [{ required: true, message: "请选择切割方式", trigger: "change" }] }, { tableValidate: B, wrongCellMask: L } = oe({ rules: O });
  I.HOOK.handleRefresh = (u, s) => {
    s.data.content = s.data.content.map((p) => p);
  };
  function P(u, s) {
    return u.issueStatusEnum === m.NOT_NESTING.V;
  }
  function G(u) {
    N.value = u, h.value = true;
  }
  async function U() {
    if (!n.selections) {
      $.warning("请至少选择一条数据");
      return;
    }
    try {
      _.value = true;
      const { validResult: u, dealList: s } = B(n.selections);
      if (u) {
        const p = s.map((o) => ({ cutConfigId: o.cutConfigId, schedulingId: o.id }));
        await le(p), F({ title: "套料下发成功", type: "success", duration: 3e3 }), n.toQuery();
      }
    } catch (u) {
      console.log("套料下发失败", u);
    } finally {
      _.value = false;
    }
  }
  return (u, s) => {
    var E;
    const p = T("common-button"), o = A, C = Q, W = T("common-table"), S = z("permission"), q = j;
    return a(), b("div", re, [H("div", ue, [d(e(ie), null, { optRight: c(() => {
      var t;
      return [y((a(), l(p, { class: "filter-item", disabled: !((t = e(n).selections) != null && t.length), size: "default", loading: _.value, icon: "el-icon-edit", type: "primary", onClick: U }, { default: c(() => s[1] || (s[1] = [v("套料下发")])), _: 1, __: [1] }, 8, ["disabled", "loading"])), [[S, e(g).save]])];
    }), _: 1 })]), y((a(), l(W, { ref_key: "tableRef", ref: k, data: e(n).data, "empty-text": e(n).emptyText, "max-height": e(D), "data-format": R.value, "cell-class-name": e(L), style: { width: "100%" }, onSelectionChange: e(n).selectionChangeHandler }, { default: c(() => [d(o, { type: "selection", width: "55", align: "center", class: "selection", selectable: P }), d(o, { label: "序号", type: "index", align: "center", width: "60" }), e(r).visible("date") ? (a(), l(o, { key: 0, prop: "date", "show-overflow-tooltip": true, label: "排产日期", width: "110", align: "center" })) : i("", true), e(r).visible("userName") ? (a(), l(o, { key: 1, prop: "userName", "show-overflow-tooltip": true, label: "操作人", "min-width": "100", align: "center" })) : i("", true), e(r).visible("orderNumber") ? (a(), l(o, { key: 2, prop: "orderNumber", "show-overflow-tooltip": true, label: "套料单号", "min-width": "120", align: "center" })) : i("", true), e(r).visible("thick") ? (a(), l(o, { key: 3, prop: "thick", "show-overflow-tooltip": true, label: "板厚（mm）", "min-width": "100", align: "center" })) : i("", true), e(r).visible("material") ? (a(), l(o, { key: 4, prop: "material", "show-overflow-tooltip": true, label: "材质", "min-width": "100", align: "center" })) : i("", true), e(r).visible("quantity") ? (a(), l(o, { key: 5, prop: "quantity", "show-overflow-tooltip": true, label: "数量（件）", "min-width": "90", align: "center" })) : i("", true), e(r).visible("totalNetWeight") ? (a(), l(o, { key: 6, prop: "totalNetWeight", "show-overflow-tooltip": true, label: "重量（kg）", "min-width": "90", align: "center" })) : i("", true), e(r).visible("cutConfigId") ? (a(), l(o, { key: 7, prop: "cutConfigId", "show-overflow-tooltip": true, label: "切割方式", "min-width": "90", align: "center" }, { default: c(({ row: { sourceRow: t } }) => [t.issueStatusEnum === e(m).NOT_NESTING.V ? (a(), l(ne, { key: 0, modelValue: t.cutConfigId, "onUpdate:modelValue": (V) => t.cutConfigId = V, layOffWayType: t.boolDrawing ? void 0 : false, clearable: "" }, null, 8, ["modelValue", "onUpdate:modelValue", "layOffWayType"])) : (a(), b("span", ce, w(t.cutConfigName), 1))]), _: 1 })) : i("", true), e(r).visible("issueStatusEnum") ? (a(), l(o, { key: 8, prop: "issueStatusEnum", "show-overflow-tooltip": true, label: "下发状态", width: "90", align: "center" }, { default: c(({ row: { sourceRow: t } }) => [t.issueStatusEnum !== e(m).NOT_NESTING.V && !t.boolNestCutEnum ? (a(), l(C, { key: 0, type: "danger" }, { default: c(() => [v(w(e(Z).VL[t.boolNestCutEnum]), 1)]), _: 2 }, 1024)) : (a(), b(M, { key: 1 }, [t.issueStatusEnum && e(m).V[t.issueStatusEnum] ? (a(), l(C, { key: 0, type: e(m).V[t.issueStatusEnum].T }, { default: c(() => [v(w(e(m).VL[t.issueStatusEnum]), 1)]), _: 2 }, 1032, ["type"])) : i("", true)], 64))]), _: 1 })) : i("", true), e(ee)([...e(g).del, ...e(g).detail]) ? (a(), l(o, { key: 9, label: "操作", width: "140px", align: "center", fixed: "right" }, { default: c(({ row: t }) => [y(d(p, { type: "info", icon: "el-icon-view", size: "default", onClick: (V) => G(t) }, null, 8, ["onClick"]), [[S, e(g).detail]]), d(e(te), { showEdit: false, showDel: t.issueStatusEnum === e(m).NOT_NESTING.V, data: t }, null, 8, ["showDel", "data"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format", "cell-class-name", "onSelectionChange"])), [[q, e(n).loading]]), d(e(ae)), d(se, { visible: h.value, "onUpdate:visible": s[0] || (s[0] = (t) => h.value = t), recordId: (E = N.value) == null ? void 0 : E.id, onDelSuccess: e(n).toQuery }, null, 8, ["visible", "recordId", "onDelSuccess"])]);
  };
} };
export {
  _e as default
};
