import { ref as f } from "vue";
import { resolveComponent as x } from "vue";
import { resolveDirective as M } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as b } from "vue";
import { createElementVNode as $ } from "vue";
import { createVNode as d } from "vue";
import { withCtx as c } from "vue";
import { withDirectives as v } from "vue";
import { createBlock as o } from "vue";
import { unref as e } from "vue";
import { createTextVNode as y } from "vue";
import { createCommentVNode as s } from "vue";
import { toDisplayString as w } from "vue";
import { Fragment as z } from "vue";
import { ElMessage as F } from "element-plus";
import { ElNotification as W } from "element-plus";
import { ElTableColumn as j } from "element-plus";
import { ElTag as Q } from "element-plus";
import { vLoading as A } from "element-plus";
import { r as K, i as J, j as X } from "../../../../../modules/machine-part-b1b959c2.js";
import { x as Y, o as Z, cb as m, az as ee, G as te, an as ae, P as ie, aw as oe } from "../../../../../shared/runtime.js";
import { E as g } from "../../../../../modules/bridge-86f96a4f.js";
import se from "./module/header.vue.js";
import le from "./module/record-detail.vue.js";
import { _ as ne } from "../../../../../modules/bridge-cut-config-select-0a6713ab.js";
const re = { class: "app-container" }, ue = { class: "head-container" }, ce = { key: 1 }, ve = { __name: "index", setup(de) {
  const I = { add: false, edit: false, del: true, download: false }, k = f(), { crud: n, columns: r, CRUD: T } = Y({ title: "预览记录", sort: [], permission: { ...g }, optShow: { ...I }, crudApi: { get: K, del: J } }, k), D = f([["askCompleteTime", ["parse-time", "{y}-{m}-{d}"]]]), { maxHeight: R } = Z({ paginate: true }), h = f(false), N = f(), _ = f(false), O = { cutConfigId: [{ required: true, message: "请选择切割方式", trigger: "change" }] }, { tableValidate: L, wrongCellMask: P } = oe({ rules: O });
  T.HOOK.handleRefresh = (u, l) => {
    l.data.content = l.data.content.map((p) => p);
  };
  function B(u, l) {
    return u.issueStatusEnum === m.NOT_NESTING.V;
  }
  function G(u) {
    N.value = u, h.value = true;
  }
  async function U() {
    if (!n.selections) {
      F.warning("请至少选择一条数据");
      return;
    }
    try {
      _.value = true;
      const { validResult: u, dealList: l } = L(n.selections);
      if (u) {
        const p = l.map((i) => ({ cutConfigId: i.cutConfigId, schedulingId: i.id }));
        await X(p), W({ title: "套料下发成功", type: "success", duration: 3e3 }), n.toQuery();
      }
    } catch (u) {
      console.log("套料下发失败", u);
    } finally {
      _.value = false;
    }
  }
  return (u, l) => {
    var S;
    const p = x("common-button"), i = j, C = Q, q = x("common-table"), E = M("permission"), H = A;
    return a(), b("div", re, [$("div", ue, [d(e(se), null, { optRight: c(() => {
      var t;
      return [v((a(), o(p, { class: "filter-item", disabled: !((t = e(n).selections) != null && t.length), size: "default", loading: _.value, icon: "el-icon-edit", type: "primary", onClick: U }, { default: c(() => l[1] || (l[1] = [y("套料下发")])), _: 1, __: [1] }, 8, ["disabled", "loading"])), [[E, e(g).save]])];
    }), _: 1 })]), v((a(), o(q, { ref_key: "tableRef", ref: k, data: e(n).data, "empty-text": e(n).emptyText, "max-height": e(R), "data-format": D.value, "cell-class-name": e(P), style: { width: "100%" }, onSelectionChange: e(n).selectionChangeHandler }, { default: c(() => [d(i, { type: "selection", width: "55", align: "center", class: "selection", selectable: B }), d(i, { label: "序号", type: "index", align: "center", width: "60" }), e(r).visible("date") ? (a(), o(i, { key: 0, prop: "date", "show-overflow-tooltip": true, label: "排产日期", width: "110", align: "center" })) : s("", true), e(r).visible("userName") ? (a(), o(i, { key: 1, prop: "userName", "show-overflow-tooltip": true, label: "操作人", "min-width": "100", align: "center" })) : s("", true), e(r).visible("orderNumber") ? (a(), o(i, { key: 2, prop: "orderNumber", "show-overflow-tooltip": true, label: "套料单号", "min-width": "120", align: "center" })) : s("", true), e(r).visible("thick") ? (a(), o(i, { key: 3, prop: "thick", "show-overflow-tooltip": true, label: "板厚（mm）", "min-width": "100", align: "center" })) : s("", true), e(r).visible("material") ? (a(), o(i, { key: 4, prop: "material", "show-overflow-tooltip": true, label: "材质", "min-width": "100", align: "center" })) : s("", true), e(r).visible("quantity") ? (a(), o(i, { key: 5, prop: "quantity", "show-overflow-tooltip": true, label: "数量（件）", "min-width": "90", align: "center" })) : s("", true), e(r).visible("totalNetWeight") ? (a(), o(i, { key: 6, prop: "totalNetWeight", "show-overflow-tooltip": true, label: "重量（kg）", "min-width": "90", align: "center" })) : s("", true), e(r).visible("cutConfigId") ? (a(), o(i, { key: 7, prop: "cutConfigId", "show-overflow-tooltip": true, label: "切割方式", "min-width": "90", align: "center" }, { default: c(({ row: { sourceRow: t } }) => [t.issueStatusEnum === e(m).NOT_NESTING.V ? (a(), o(ne, { key: 0, modelValue: t.cutConfigId, "onUpdate:modelValue": (V) => t.cutConfigId = V, clearable: "", isDisabled: t.thick === "其它" }, null, 8, ["modelValue", "onUpdate:modelValue", "isDisabled"])) : (a(), b("span", ce, w(t.cutConfigName), 1))]), _: 1 })) : s("", true), e(r).visible("issueStatusEnum") ? (a(), o(i, { key: 8, prop: "issueStatusEnum", "show-overflow-tooltip": true, label: "下发状态", width: "90", align: "center" }, { default: c(({ row: { sourceRow: t } }) => [t.issueStatusEnum !== e(m).NOT_NESTING.V && !t.boolNestCutEnum ? (a(), o(C, { key: 0, type: "danger" }, { default: c(() => [y(w(e(ee).VL[t.boolNestCutEnum]), 1)]), _: 2 }, 1024)) : (a(), b(z, { key: 1 }, [t.issueStatusEnum && e(m).V[t.issueStatusEnum] ? (a(), o(C, { key: 0, type: e(m).V[t.issueStatusEnum].T }, { default: c(() => [y(w(e(m).VL[t.issueStatusEnum]), 1)]), _: 2 }, 1032, ["type"])) : s("", true)], 64))]), _: 1 })) : s("", true), e(te)([...e(g).del, ...e(g).detail]) ? (a(), o(i, { key: 9, label: "操作", width: "140px", align: "center", fixed: "right" }, { default: c(({ row: t }) => [v(d(p, { type: "info", icon: "el-icon-view", size: "default", onClick: (V) => G(t) }, null, 8, ["onClick"]), [[E, e(g).detail]]), d(e(ae), { showEdit: false, showDel: t.issueStatusEnum === e(m).NOT_NESTING.V, data: t }, null, 8, ["showDel", "data"])]), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format", "cell-class-name", "onSelectionChange"])), [[H, e(n).loading]]), d(e(ie)), d(le, { visible: h.value, "onUpdate:visible": l[0] || (l[0] = (t) => h.value = t), recordId: (S = N.value) == null ? void 0 : S.id, onDelSuccess: e(n).toQuery }, null, 8, ["visible", "recordId", "onDelSuccess"])]);
  };
} };
export {
  ve as default
};
