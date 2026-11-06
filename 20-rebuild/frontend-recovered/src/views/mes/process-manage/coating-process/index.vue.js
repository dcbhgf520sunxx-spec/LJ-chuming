import { ref as m } from "vue";
import { provide as I } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as w } from "vue";
import { createElementBlock as B } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as n } from "vue";
import { unref as a } from "vue";
import { withDirectives as Y } from "vue";
import { createBlock as b } from "vue";
import { withCtx as i } from "vue";
import { toDisplayString as p } from "vue";
import { normalizeClass as d } from "vue";
import { createTextVNode as V } from "vue";
import { withModifiers as J } from "vue";
import { createCommentVNode as W } from "vue";
import { ElTableColumn as X } from "element-plus";
import { ElTag as Z } from "element-plus";
import { vLoading as tt } from "element-plus";
import { _ as at, x as et, ow as ot, ox as nt, ou as rt, o as it, ib as l, bY as lt, p as st, G as pt, P as ut, oy as dt, or as ct, os as wt, ot as ft } from "../../../../shared/runtime.js";
import mt from "./module/header.vue.js";
import vt from "./paint-config/index.vue.js";
import gt from "./creation-process/index.vue.js";
import St from "./creat-project-quota/index.vue.js";
import "../../../../modules/paint-config-780a81bc.js";
import "./paint-config/module/form.vue.js";
import "./paint-config/module/header.vue.js";
import "../../../../modules/ExcelUploadBtn-acccae97.js";
import "../../../../modules/creation-process-d3879d47.js";
import "./creation-process/module/header.vue.js";
import "./creation-process/module/form.vue.js";
const ht = { class: "app-container wrap" }, bt = { class: "head-container" }, _t = { key: 1 }, yt = { __name: "index", setup(xt, { expose: E }) {
  const N = m(), A = m(false), P = m(false), T = m(), _ = m(), { crud: c, CRUD: F } = et({ title: "涂装工艺", permission: { ...ot }, crudApi: { get: nt, detail: rt }, hasPagination: true }, N), { maxHeight: M } = it({ paginate: true }), y = m([]), k = m([]), g = m([]);
  F.HOOK.handleRefresh = async (s, { data: r }) => {
    r.content = r.content.flatMap((o, S) => {
      var f;
      return (f = o == null ? void 0 : o.detailList) == null ? void 0 : f.map((v) => ({ index: S + 1, ...o, ...v, id: o.id }));
    });
  };
  function Q({ row: s, column: r, rowIndex: o, columnIndex: S }) {
    if (["index", "project", "monomer", "serialNumber", "createUser", "surfaceArea", "createDate", "approvalStatus", "operation"].includes(r.property)) {
      const v = s.index || "", L = c.data[o - 1], C = L ? L.index : null;
      if (v === C) return { rowspan: 0, colspan: 0 };
      {
        let t = 1;
        for (let e = o + 1; e < c.data.length; e++) {
          const x = c.data[e].index || "";
          if (x && v && x === v) t++;
          else break;
        }
        return { rowspan: t, colspan: 1 };
      }
    }
  }
  function G() {
    A.value = true, _.value = {};
  }
  function H() {
    P.value = true, _.value = {};
  }
  function $() {
    T.value = true;
  }
  function q(s) {
    P.value = true, _.value = s;
  }
  async function j() {
    try {
      const { content: s } = await ct();
      y.value = s || [];
    } catch (s) {
      console.log(s);
    }
  }
  async function R() {
    try {
      const { content: s } = await wt();
      k.value = s || [];
    } catch (s) {
      console.log(s);
    }
  }
  async function U() {
    try {
      const { content: s } = await ft();
      g.value = s || [];
    } catch (s) {
      console.log(s);
    }
  }
  j(), R(), U();
  function O() {
    console.log(111), j(), R(), U();
  }
  function z() {
    console.log("审批通过"), c.resetQuery();
  }
  return I("paintBrandList", y), I("paintTypeList", k), I("paintselectList", g), E({ refresh: c.toQuery }), (s, r) => {
    const o = X, S = D("table-cell-tag"), f = Z, v = D("common-button"), L = D("common-table"), C = tt;
    return w(), B("div", ht, [u("div", bt, [n(a(mt), { paintBrandList: y.value, paintSelectList: g.value, onCreationProcess: G, onOpenPaintConfig: $, onCreatProjectQuota: H }, null, 8, ["paintBrandList", "paintSelectList"])]), Y((w(), b(L, { ref_key: "tableRef", ref: N, data: a(c).data, "empty-text": a(c).emptyText, "max-height": a(M), "span-method": Q, "return-source-data": "", showEmptySymbol: false, style: { width: "100%" } }, { default: i(() => [n(o, { label: "序号", prop: "index", align: "center", width: "60", fixed: "left" }, { default: i((t) => [u("span", null, p(t.row.index), 1)]), _: 1 }), n(o, { prop: "project", label: "项目", "show-overflow-tooltip": "", align: "center", "min-width": "180", fixed: "left" }, { default: i((t) => {
      var e, h;
      return [u("span", { class: d({ strikethrough: t.row.boolInvalid && t.row.approvalStatus === a(l).PASS.V }) }, p((e = t.row.project) == null ? void 0 : e.serialNumber) + " - " + p((h = t.row.project) == null ? void 0 : h.shortName), 3), n(S, { show: t.row.boolInvalid && t.row.approvalStatus === a(l).PASS.V, name: "已作废", color: "#f56c6c" }, null, 8, ["show"]), n(S, { show: t.row.boolInvalid && t.row.approvalStatus === a(l).AUDITING.V, name: "作废中", color: "#f56c6c" }, null, 8, ["show"]), n(S, { show: t.row.boolInApproval && t.row.approvalStatus === a(l).PASS.V, name: "变更中", color: "#e64242" }, null, 8, ["show"])];
    }), _: 1 }), n(o, { prop: "monomer", label: "单体", "show-overflow-tooltip": "", align: "center", "min-width": "140", fixed: "left" }, { default: i((t) => {
      var e, h, x;
      return [(e = t.row.monomerList) != null && e.length ? (w(), B("span", { key: 0, class: d({ strikethrough: t.row.boolInvalid && t.row.approvalStatus === a(l).PASS.V }) }, p((x = (h = t.row.monomerList) == null ? void 0 : h.map((K) => K.name)) == null ? void 0 : x.join("、")), 3)) : (w(), B("span", _t, "全部单体"))];
    }), _: 1 }), n(o, { prop: "serialNumber", label: "工艺单号", "show-overflow-tooltip": "", align: "center", "min-width": "160", fixed: "left" }, { default: i((t) => [u("span", { class: d({ strikethrough: t.row.boolInvalid && t.row.approvalStatus === a(l).PASS.V }) }, p(t.row.serialNumber || "-"), 3)]), _: 1 }), n(o, { prop: "paintingTypeEnum", label: "油漆类型", align: "center" }, { default: i((t) => [u("span", { class: d({ strikethrough: t.row.boolInvalid && t.row.approvalStatus === a(l).PASS.V }) }, p(a(lt).VL[t.row.paintingTypeEnum] || "-"), 3)]), _: 1 }), n(o, { prop: "paintBrand", label: "品牌", "show-overflow-tooltip": "", align: "center", "min-width": "100" }, { default: i((t) => [u("span", { class: d({ strikethrough: t.row.boolInvalid && t.row.approvalStatus === a(l).PASS.V }) }, p(t.row.paintBrand || "-"), 3)]), _: 1 }), n(o, { prop: "paintType", label: "材质", "show-overflow-tooltip": "", align: "center", "min-width": "180" }, { default: i((t) => [u("span", { class: d({ strikethrough: t.row.boolInvalid && t.row.approvalStatus === a(l).PASS.V }) }, p(t.row.paintType || "-"), 3)]), _: 1 }), n(o, { prop: "surfaceArea", label: "表面积（㎡）", align: "center", "min-width": "100" }, { default: i((t) => {
      var e;
      return [u("span", { class: d({ strikethrough: t.row.boolInvalid && t.row.approvalStatus === a(l).PASS.V }) }, p(((e = t.row.surfaceArea) == null ? void 0 : e.toFixed(2)) ?? "-"), 3)];
    }), _: 1 }), n(o, { prop: "paintFilmThickness", label: "漆膜厚度（μm）", align: "center", "min-width": "120" }, { default: i((t) => {
      var e;
      return [u("span", { class: d({ strikethrough: t.row.boolInvalid && t.row.approvalStatus === a(l).PASS.V }) }, p(((e = t.row.paintFilmThickness) == null ? void 0 : e.toFixed(2)) ?? "-"), 3)];
    }), _: 1 }), n(o, { prop: "lossCoefficient", label: "损耗系数", align: "center" }, { default: i((t) => {
      var e;
      return [u("span", { class: d({ strikethrough: t.row.boolInvalid && t.row.approvalStatus === a(l).PASS.V }) }, p(((e = t.row.lossCoefficient) == null ? void 0 : e.toFixed(2)) ?? "-"), 3)];
    }), _: 1 }), n(o, { prop: "quantity", label: "数量", align: "center" }, { default: i((t) => {
      var e;
      return [u("span", { class: d({ strikethrough: t.row.boolInvalid && t.row.approvalStatus === a(l).PASS.V }) }, p(((e = t.row.quantity) == null ? void 0 : e.toFixed(2)) ?? "-"), 3)];
    }), _: 1 }), n(o, { prop: "weight", label: "油漆用量（kg）", align: "center", "min-width": "120" }, { default: i((t) => {
      var e;
      return [u("span", { class: d({ strikethrough: t.row.boolInvalid && t.row.approvalStatus === a(l).PASS.V }) }, p(((e = t.row.weight) == null ? void 0 : e.toFixed(2)) ?? "-"), 3)];
    }), _: 1 }), n(o, { prop: "createUser", label: "创建人", align: "center", "min-width": "100" }, { default: i((t) => {
      var e;
      return [u("span", { class: d({ strikethrough: t.row.boolInvalid && t.row.approvalStatus === a(l).PASS.V }) }, p(((e = t.row.createUser) == null ? void 0 : e.name) || "-"), 3)];
    }), _: 1 }), n(o, { prop: "createDate", label: "日期", align: "center", "min-width": "100" }, { default: i((t) => [u("span", { class: d({ strikethrough: t.row.boolInvalid && t.row.approvalStatus === a(l).PASS.V }) }, p(t.row.createDate ? a(st)(t.row.createDate, "{y}-{m}-{d}") : "-"), 3)]), _: 1 }), n(o, { key: "approvalStatus", prop: "approvalStatus", label: "状态", align: "center", "min-width": "110", fixed: "right" }, { default: i((t) => {
      var e;
      return [t.row.boolInvalid && t.row.approvalStatus === a(l).PASS.V ? (w(), b(f, { key: 0, type: "danger", effect: "plain" }, { default: i(() => r[5] || (r[5] = [V(" 已作废 ")])), _: 1, __: [5] })) : t.row.boolInvalid && t.row.approvalStatus === a(l).AUDITING.V ? (w(), b(f, { key: 1, type: "warning", effect: "plain" }, { default: i(() => r[6] || (r[6] = [V(" 作废审批中 ")])), _: 1, __: [6] })) : t.row.boolInApproval && t.row.approvalStatus === a(l).PASS.V ? (w(), b(f, { key: 2, type: "warning", effect: "plain" }, { default: i(() => r[7] || (r[7] = [V(" 变更中 ")])), _: 1, __: [7] })) : (w(), b(f, { key: 3, type: (e = a(l).V[t.row.approvalStatus]) == null ? void 0 : e.TAG, effect: "plain" }, { default: i(() => [V(p(a(l).VL[t.row.approvalStatus]), 1)]), _: 2 }, 1032, ["type"]))];
    }), _: 1 }), n(o, { label: "操作", prop: "operation", align: "center", fixed: "right" }, { default: i((t) => [a(pt)(a(c).permission.details) ? (w(), b(v, { key: 0, icon: "el-icon-view", type: "primary", size: "default", onClick: J((e) => a(c).toDetail(t.row), ["stop"]) }, null, 8, ["onClick"])) : W("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[C, a(c).loading]]), n(a(ut)), n(a(gt), { visible: A.value, "onUpdate:visible": r[0] || (r[0] = (t) => A.value = t), paintBrandList: y.value, paintTypeList: k.value, paintSelectList: g.value, secondaryData: _.value, onCreationClose: r[1] || (r[1] = (t) => a(c).refresh()) }, null, 8, ["visible", "paintBrandList", "paintTypeList", "paintSelectList", "secondaryData"]), n(a(St), { visible: P.value, "onUpdate:visible": r[2] || (r[2] = (t) => P.value = t), paintSelectList: g.value, secondaryData: _.value, onSubmitSuccess: r[3] || (r[3] = (t) => a(c).refresh()) }, null, 8, ["visible", "paintSelectList", "secondaryData"]), n(a(vt), { visible: T.value, "onUpdate:visible": r[4] || (r[4] = (t) => T.value = t), paintBrandList: y.value, paintTypeList: k.value, paintSelectList: g.value, onConfigSuccess: O }, null, 8, ["visible", "paintBrandList", "paintTypeList", "paintSelectList"]), n(a(dt), { editFlag: true, onRecompose: q, onAuditSuccess: z })]);
  };
} }, Ut = at(yt, [["__scopeId", "data-v-145966ee"]]);
export {
  Ut as default
};
