import { ref as g } from "vue";
import { computed as ee } from "vue";
import { resolveComponent as D } from "vue";
import { resolveDirective as C } from "vue";
import { openBlock as c } from "vue";
import { createBlock as w } from "vue";
import { withCtx as r } from "vue";
import { createVNode as e } from "vue";
import { withDirectives as O } from "vue";
import { createElementVNode as te } from "vue";
import { createTextVNode as m } from "vue";
import { toDisplayString as v } from "vue";
import { unref as l } from "vue";
import { createElementBlock as x } from "vue";
import { createCommentVNode as E } from "vue";
import { ElMessage as I } from "element-plus";
import { ElTag as oe } from "element-plus";
import { ElPopconfirm as ae } from "element-plus";
import { ElTableColumn as le } from "element-plus";
import { d as re, r as ne, w as T } from "../../../../../modules/scheduling-work-order-cf0c3c01.js";
import { D as h, gt as ie, o as se, L as ce, kA as N, ba as de } from "../../../../../shared/runtime.js";
const pe = { key: 1 }, me = ["src"], ue = { key: 1 }, ye = { __name: "detail", props: { project: { type: Object, default: () => {
} } }, setup(z) {
  const B = z, P = g(), L = g(), y = g(true), f = g([]), k = g(true), V = g([["askCompleteTime", ["parse-time", "{y}-{m}-{d}"]], ["thickness", ["to-fixed", h.MES_ENCLOSURE_T__MM]], ["totalLength", ["to-fixed", h.MES_ENCLOSURE_L__M]], ["totalWeight", ["to-fixed", h.COM_WT__KG]]]), { CRUD: j, crud: d, detail: o } = ie(), { maxHeight: W } = se({ mainBox: ".enclosure-scheduling-work-order-detail", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true }, () => ee(() => !d.detailLoading));
  function H() {
    d.cancelDetail(), d.toQuery();
  }
  async function q() {
    var a;
    try {
      await ne((a = o == null ? void 0 : o.rowDetail) == null ? void 0 : a.id);
    } catch {
      console.log("下载成功上报失败");
    }
  }
  function A(a) {
    return de(a, { props: ["quantity", ["totalLength", h.MES_ENCLOSURE_L__M], ["totalWeight", h.COM_WT__KG]] });
  }
  const F = () => {
    y.value = true, L.value.clearSelection();
  };
  function G(a) {
    return !y.value && a.booleReport !== 1;
  }
  const U = (a) => {
    console.log(a), a.length > 0 ? (k.value = false, f.value = [], a.forEach((t) => {
      f.value.push(t.id);
    })) : k.value = true;
  }, K = async () => {
    try {
      await T({ orderId: o.rowDetail.id, taskIds: f.value }), y.value = true, d.toDetail({ ...o.rowDetail }), I.success("批量工单撤回成功");
    } catch (a) {
      console.log(a, "批量撤回失败");
    }
  }, $ = async (a) => {
    f.value = [];
    try {
      f.value.push(a.id), await T({ orderId: o.rowDetail.id, taskIds: f.value }), d.toDetail({ ...o.rowDetail }), I.success("当前工单撤回成功");
    } catch (t) {
      console.log(t, "撤回失败");
    }
  };
  return j.HOOK.beforeDetailLoaded = async (a) => {
    var t;
    (o.content || []).forEach((u) => {
      u.totalLength = (u.totalLength || 0) / 1e3;
    }), ((t = o.content) == null ? void 0 : t.length) === 0 && (a.cancelDetail(), a.toQuery());
  }, (a, t) => {
    var S, M;
    const u = oe, b = D("common-button"), R = ae, n = le, Q = D("common-table"), J = D("common-drawer"), X = C("empty-text"), Y = C("parse-project"), Z = C("permission");
    return c(), w(J, { ref_key: "drawerRef", ref: P, "before-close": H, "content-loading": l(d).detailLoading, "show-close": true, title: (M = (S = l(o)) == null ? void 0 : S.rowDetail) == null ? void 0 : M.orderNumber, visible: l(d).detailVisible, "custom-class": "enclosure-scheduling-work-order-detail", size: "100%" }, { titleAfter: r(() => [e(u, { effect: "plain", size: "large" }, { default: r(() => [O(te("span", null, null, 512), [[X], [Y, { project: B.project }]])]), _: 1 }), e(u, { effect: "plain", size: "large", type: "success" }, { default: r(() => {
      var i, s;
      return [m(v((s = (i = l(o)) == null ? void 0 : i.rowDetail) == null ? void 0 : s.factoryName), 1)];
    }), _: 1 }), e(u, { effect: "plain", size: "large", type: "success" }, { default: r(() => {
      var i, s;
      return [m(v((s = (i = l(o)) == null ? void 0 : i.rowDetail) == null ? void 0 : s.workshopName), 1)];
    }), _: 1 }), e(u, { effect: "plain", size: "large", type: "success" }, { default: r(() => {
      var i, s, _, p;
      return [m(v((s = (i = l(o)) == null ? void 0 : i.rowDetail) == null ? void 0 : s.productionLineName) + " / " + v((p = (_ = l(o)) == null ? void 0 : _.rowDetail) == null ? void 0 : p.leaderName), 1)];
    }), _: 1 })]), titleRight: r(() => {
      var i, s;
      return [y.value ? (c(), w(b, { key: 0, class: "filter-item", size: "default", type: "primary", onClick: t[0] || (t[0] = (_) => y.value = false) }, { default: r(() => t[1] || (t[1] = [m(" 编辑 ")])), _: 1, __: [1] })) : (c(), x("div", pe, [e(b, { size: "default", type: "warning", onClick: F }, { default: r(() => t[2] || (t[2] = [m("取消编辑")])), _: 1, __: [2] }), e(R, { "cancel-button-text": "取消", "confirm-button-text": "确定", "icon-color": "red", title: "是否确定批量撤回?", onConfirm: K }, { reference: r(() => [e(b, { disabled: k.value, size: "default", type: "danger" }, { default: r(() => t[3] || (t[3] = [m("批量撤回")])), _: 1, __: [3] }, 8, ["disabled"])]), _: 1 })])), O((c(), w(ce, { fn: l(re), params: { id: (s = (i = l(o)) == null ? void 0 : i.rowDetail) == null ? void 0 : s.id }, class: "filter-item", onDownloadSuccess: q }, { default: r(() => t[4] || (t[4] = [m(" 下载排产工单详情 ")])), _: 1, __: [4] }, 8, ["fn", "params"])), [[Z, l(d).permission.print]])];
    }), content: r(() => [e(Q, { ref_key: "tableRef", ref: L, data: l(o).content, "data-format": V.value, "max-height": l(W), "summary-method": A, "show-summary": "", onSelectionChange: U }, { default: r(() => {
      var i, s, _;
      return [e(n, { selectable: G, align: "center", type: "selection", width: "55" }), e(n, { align: "center", label: "序号", type: "index", width: "60" }), e(n, { key: "areaName", align: "center", label: "区域", prop: "areaName", "show-overflow-tooltip": "" }), e(n, { key: "name", align: "center", label: "名称", prop: "name", "show-overflow-tooltip": "" }), e(n, { key: "serialNumber", align: "center", label: "编号", prop: "serialNumber", "show-overflow-tooltip": "" }), ((i = l(o).rowDetail) == null ? void 0 : i.category) !== l(N).FOLDING_PIECE.V ? (c(), w(n, { key: "plate", align: "center", label: "板型", prop: "plate", "show-overflow-tooltip": "" })) : E("", true), e(n, { key: "thickness", align: "center", label: "厚度(mm)", prop: "thickness", "show-overflow-tooltip": "" }), e(n, { key: "width", align: "center", label: "宽度(mm)", prop: "width", "show-overflow-tooltip": "" }), e(n, { key: "length", align: "center", label: "单长(mm)", prop: "length", "show-overflow-tooltip": "" }), e(n, { key: "quantity", align: "center", label: "数量(件)", prop: "quantity", "show-overflow-tooltip": "" }), e(n, { key: "totalLength", align: "center", label: "总长度(m)", prop: "totalLength", "show-overflow-tooltip": "" }), ((s = l(o).rowDetail) == null ? void 0 : s.category) !== l(N).SANDWICH_BOARD.V ? (c(), w(n, { key: "totalWeight", align: "center", label: "总重量(kg)", prop: "totalWeight", "show-overflow-tooltip": "" })) : E("", true), e(n, { key: "askCompleteTime", align: "center", label: "完成日期", prop: "askCompleteTime", "show-overflow-tooltip": "" }), ((_ = l(o).rowDetail) == null ? void 0 : _.category) === l(N).FOLDING_PIECE.V ? (c(), w(n, { key: "relativePath", align: "center", label: "图片", prop: "relativePath", "show-overflow-tooltip": "" }, { default: r(({ row: p }) => [p.relativePath ? (c(), x("img", { key: 0, src: p.relativePath, alt: "加载失败", style: { "max-width": "100%", display: "block" } }, null, 8, me)) : (c(), x("span", ue, "未上传图片"))]), _: 1 })) : E("", true), e(n, { align: "center", label: "操作" }, { default: r(({ row: p }) => [e(R, { "cancel-button-text": "取消", "confirm-button-text": "确定", "icon-color": "red", title: "是否确认撤回操作?", onConfirm: (fe) => $(p) }, { reference: r(() => [e(b, { disabled: p.booleReport === 1, size: "default", type: "danger" }, { default: r(() => t[5] || (t[5] = [m("撤回")])), _: 2, __: [5] }, 1032, ["disabled"])]), _: 2 }, 1032, ["onConfirm"])]), _: 1 })];
    }), _: 1 }, 8, ["data", "data-format", "max-height"])]), _: 1 }, 8, ["content-loading", "title", "visible"]);
  };
} };
export {
  ye as default
};
