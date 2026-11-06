import { computed as ct } from "vue";
import { unref as l } from "vue";
import { ref as u } from "vue";
import { provide as Q } from "vue";
import { watch as Ie } from "vue";
import { onMounted as ft } from "vue";
import { resolveComponent as U } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as R } from "vue";
import { createElementVNode as v } from "vue";
import { createVNode as r } from "vue";
import { normalizeStyle as F } from "vue";
import { withCtx as s } from "vue";
import { createBlock as _ } from "vue";
import { createTextVNode as m } from "vue";
import { createCommentVNode as y } from "vue";
import { toDisplayString as w } from "vue";
import { withDirectives as ue } from "vue";
import { vShow as de } from "vue";
import { ElMessage as Ee } from "element-plus";
import { ElDivider as pt } from "element-plus";
import { ElBadge as vt } from "element-plus";
import { ElCard as mt } from "element-plus";
import { ElTag as ht } from "element-plus";
import { ElDescriptionsItem as gt } from "element-plus";
import { ElDescriptions as yt } from "element-plus";
import { ElTableColumn as _t } from "element-plus";
import { ElImage as bt } from "element-plus";
import { ElTooltip as wt } from "element-plus";
import { vLoading as kt } from "element-plus";
import { _ as St, x as It, qA as S, qB as Et, o as xe, qC as xt, oW as j, G as x, qD as Nt, bV as Pt, L as Ct, qE as Rt, qF as V, qG as Ne, qH as Lt, qI as qt, P as Dt, qJ as Tt, V as Pe, qK as Vt, i as Ce, ba as Ot } from "../../../../shared/runtime.js";
import Bt from "./module/header.vue.js";
import At from "./module/preview.vue.js";
import Mt from "./module/pad-block-dialog.vue.js";
import zt from "./module/project-list.vue.js";
import Ht from "./module/eliminate-dialog.vue.js";
import Qt from "./module/picture-dialog.vue.js";
import Ut from "./un-production-record/index.vue.js";
import Ft from "../../../plan/technical-data-manage/technical-achievement/components/drawing-upload-btn.vue.js";
import "../../../../modules/nesting-group-config-c479d3e5.js";
import "./module/drill-scheduling-dialog.vue.js";
import "./module/materials-drawer.vue.js";
import "./module/binding-detail.vue.js";
import "../../../../modules/parallel-config-554d8028.js";
import "../../../../modules/base-6bc46ddf.js";
import "../common/project-header-time.vue.js";
import "./un-production-record/module/edit-form.vue.js";
import "./un-production-record/module/header.vue.js";
import "../../../../modules/use-scheduling-groups-e49a6ba2.js";
import "../../../../modules/artifact-f1b0ca44.js";
import "../../../../modules/index-ce9deea8.js";
const jt = { class: "app-container wrap" }, $t = { class: "wrap-left" }, Wt = { class: "wrap-right" }, Gt = { key: 0, class: "head-container wrap-right-head" }, Kt = { style: { float: "right" } }, Yt = { style: { display: "flex" } }, Jt = { key: 1, class: "head-send" }, Xt = { class: "error-slot" }, Zt = { key: 0 }, ea = { key: 1 }, ta = { class: "error-slot" }, aa = { key: 0 }, la = { key: 1 }, na = { __name: "index", setup(ia) {
  const Re = ct(() => {
    var t;
    return l((t = ce.value) == null ? void 0 : t.workShopId);
  }), Le = { add: false, edit: false, del: false, download: false }, $ = u([]), W = u([]), G = u(), ce = u(), P = u(), K = u(false), Y = u(), f = u([]), h = u([]), J = u(false), p = u([]), I = u([]), g = u([]), { crud: o, CRUD: X } = It({ title: "零件排产", sort: [], permission: { ...S }, optShow: { ...Le }, crudApi: { ...Et }, queryOnPresenterCreated: false, hasPagination: true, requiredQuery: ["taskOrderIds"] }, P);
  o.page.size = 100, Q("permission", S), Q("materialList", W), Q("thickList", $);
  const qe = (t) => !p.value.includes(t.id) && t.issuedToNestingSoftwareStatus !== V.ISSUED_IN_PROGRESS.V;
  Ie(() => o.query.thick, (t) => {
    oe.value = false;
  });
  const { maxHeight: De } = xe({ extraBox: [".wrap-right-head", ".head-send"], paginate: true }), { maxHeight: Te } = xe({ extraBox: "", paginate: false });
  Ie(() => o.query.sendNestingStatus, () => {
    fe();
  });
  const A = u([]), L = u({ totalNeedWeight: 0, totalSchedulingQuantity: 0 }), Z = u({}), Ve = u(false), ee = u(false), M = u(false), te = u(false), ae = u([]), C = u([]), b = u([]), q = u(false);
  Q("workShopList", ae);
  function Oe({ row: t, rowIndex: e }) {
    return t.issuedToNestingSoftwareStatus === V.ISSUANCE_FAILED.V ? "error-row" : "";
  }
  function Be({ row: t, rowIndex: e }) {
    return t.issuedToNestingSoftwareStatus === V.ISSUANCE_FAILED.V ? "error-row" : "";
  }
  X.HOOK.handleRefresh = (t, e) => {
    var i, n;
    L.value.totalNeedWeight = ((i = e.data.content[0]) == null ? void 0 : i.totalNeedWeight) || 0, L.value.totalSchedulingQuantity = ((n = e.data.content[0]) == null ? void 0 : n.totalSchedulingQuantity) || 0, e.data.content = e.data.content.map((d) => (t.query.sendNestingStatus && (d.quantity = d.needQuantity), d.picturePath = d.picturePath ? `${d.picturePath}?pic=${Math.random()}` : void 0, d.state = false, d)), K.value = false;
  };
  async function Ae(t) {
    const e = await Tt({ id: t.drwaingId }), i = e.data, n = e.headers;
    if (!i || !n) return false;
    const d = n["content-type"], D = window.URL.createObjectURL(new Blob([e.data], { type: d })), E = document.createElement("a");
    E.href = D, E.setAttribute("download", `${t.serialNumber}.dxf`), document.body.appendChild(E), E.click(), E.remove();
  }
  function Me(t) {
    return { projectId: t.project.id, productId: t.productId, monomerId: t.monomerId, productType: 1, dataType: 2 };
  }
  function ze() {
    Z.value.checked = false;
  }
  const He = (t) => {
    t ? I.value = [t] : I.value = g.value, J.value = true;
  };
  async function fe() {
    try {
      const t = await xt({ steelPlateTypeEnum: [j.SECONDARY_MEMBER.V, j.PRIMARY_MEMBER.V], sendNestingStatus: q.value });
      ae.value = t;
    } catch (t) {
      console.log(t, "获取车间列表");
    }
  }
  const le = u();
  ft(() => {
    fe();
  });
  async function Qe() {
    o.firstLoaded && o.page.hasNextPage && await o.pageChangeHandler(++o.page.page);
  }
  function Ue(t, e) {
    W.value = t, $.value = e;
  }
  X.HOOK.beforeRefresh = () => {
    o.query.boolDxfEnum = G.value, A.value = [], L.value = { totalNetWeight: 0, quantity: 0 };
  }, X.HOOK.afterRefresh = () => {
    o.data.forEach((t) => {
      A.value.push(t);
    });
  };
  function Fe(t) {
    g.value = t;
  }
  const O = u(void 0);
  let pe = "";
  function je({ taskOrderIds: t, sendNestingStatus: e, projectId: i }, n, d) {
    var D, E;
    o.query.yearMonthArray = n, o.query.steelPlateTypeEnum = [j.PRIMARY_MEMBER.V, j.SECONDARY_MEMBER.V], o.query.sendNestingStatus = e, o.query.taskOrderIds = t, O.value = i, t.length || (L.value = {}), pe !== O.value && (f.value = [], h.value = [], I.value = [], b.value = [], p.value = []), pe = O.value, (D = le.value) == null || D.fetchMaterial(), (E = le.value) == null || E.fetchTick(), o.toQuery();
  }
  function $e(t) {
    q.value = t, o.query.taskOrderIds = [];
  }
  async function We() {
    o.toQuery(), p.value = b.value.filter((t) => !f.value.some((e) => e.id === t)), b.value = [], o.toQuery();
  }
  async function Ge({ type: t }) {
    o.toQuery(), t ? (p.value = p.value.filter((e) => !f.value.some((i) => i.id === e)), f.value = []) : (p.value = p.value.filter((e) => !h.value.some((i) => i.id === e)), h.value = []), o.page.page = 1, o.toQuery();
  }
  function ne({ row: t, id: e, type: i }) {
    if (p.value = p.value.filter((n) => n !== e), i === 1) {
      const n = f.value.findIndex((d) => d.id === e);
      f.value.splice(n, 1), C.value = [...f.value];
    } else if (i === 2) b.value = b.value.filter((n) => n.id !== e);
    else if (i === 3) I.value = I.value.filter((n) => n.id !== e), P.value.toggleRowSelection(t, false);
    else {
      const n = h.value.findIndex((d) => d.id === e);
      h.value.splice(n, 1), C.value = [...h.value];
    }
  }
  function ie({ list: t, type: e }) {
    p.value = p.value.filter((i) => !t.some((n) => n.id === i)), e === 1 ? (f.value = f.value.filter((i) => !t.some((n) => n.id === i.id)), C.value = Pe(f.value)) : e === 2 ? b.value = b.value.filter((i) => !t.some((n) => n.id === i.id)) : e === 3 ? (I.value = I.value.filter((i) => !t.some((n) => n.id === i.id)), t.forEach((i) => {
      P.value.toggleRowSelection(i, false);
    })) : (h.value = h.value.filter((i) => !t.some((n) => n.id === i.id)), C.value = Pe(h.value));
  }
  function Ke({ projectId: t, monomerId: e, type: i }) {
    I.value = I.value.map((n) => (n.project.id === t && n.monomerId === e && Array.isArray(i) && i.forEach((d) => {
      d.serialNumber === n.serialNumber && (n.state = d.id === n.drwaingId);
    }), { ...n })), o.toQuery();
  }
  const oe = u(false), B = u([]);
  function Ye() {
    Je(), oe.value = false, o.toQuery();
  }
  function ve(t, e) {
    Ve.value && t && (Z.value = e, M.value = true);
    const i = B.value.findIndex((d) => d.id === e.id);
    t ? i === -1 && B.value.push(e) : i > -1 && B.value.splice(i, 1), A.value.forEach((d) => {
      d.id === e.id && (d.checked = t);
    });
    let n = false;
    B.value.forEach((d) => {
      if (!d.imgLoad || !d.picturePath) return n = true, false;
    }), K.value = n;
  }
  function Je(t) {
    oe.value = t, A.value.forEach((e) => {
      (e.imgLoad || !e.picturePath || e.imgLoad || e.picturePath) && (e.checked = t, ve(t, e));
    }), K.value = t;
  }
  async function Xe() {
    var t;
    te.value = true;
    try {
      await Vt((t = o.query) == null ? void 0 : t.taskOrderIds), Ee.success("处理成功！"), o.toQuery();
    } catch (e) {
      console.log(e, "手动处理下发中零件");
    } finally {
      te.value = false;
    }
  }
  const z = u(false), Ze = () => {
    if (g.value.some((n) => !Ce(n.picturePath))) {
      Ee.error("没有图片不能进行套料排产");
      return;
    }
    const e = g.value, i = new Set(e.map((n) => n.id));
    f.value = [.../* @__PURE__ */ new Set([...f.value, ...e])], p.value = [.../* @__PURE__ */ new Set([...p.value, ...i])], e.forEach((n) => {
      P.value.toggleRowSelection(n, false);
    }), g.value = [];
  };
  function et() {
    Y.value = 1, z.value = true, C.value = f.value;
  }
  const tt = () => {
    const t = new Set(g.value.map((e) => e.id));
    h.value = [.../* @__PURE__ */ new Set([...h.value, ...g.value])], p.value = [.../* @__PURE__ */ new Set([...p.value, ...t])], g.value.forEach((e) => {
      P.value.toggleRowSelection(e, false);
    }), g.value = [];
  };
  function at() {
    Y.value = 0, z.value = true, C.value = h.value;
  }
  const lt = () => {
    const t = g.value, e = new Set(t.map((i) => i.id));
    b.value = [.../* @__PURE__ */ new Set([...b.value, ...t])], p.value = [.../* @__PURE__ */ new Set([...p.value, ...e])], t.forEach((i) => {
      P.value.toggleRowSelection(i, false);
    }), g.value = [];
  };
  function nt() {
    M.value = true;
  }
  const me = u(false), H = u([]);
  function it(t) {
    const e = H.value.find((i) => i.id === t.id);
    Ce(e) ? e.usedQuantity += t.usedQuantity : H.value.push(JSON.parse(JSON.stringify(t)));
  }
  function ot(t) {
    return Ot(t, { props: ["weight", "quantity"] });
  }
  return (t, e) => {
    var ye, _e, be, we, ke, Se;
    const i = pt, n = U("common-button"), d = vt, D = mt, E = U("common-radio-button"), se = ht, re = gt, st = yt, k = _t, he = U("table-cell-tag"), ge = bt, rt = wt, ut = U("common-table"), dt = kt;
    return c(), R("div", jt, [v("div", $t, [r(l(zt), { ref_key: "projectListRef", ref: ce, onProjectClick: je, onSendStatus: $e, "work-shop-list": ae.value }, null, 8, ["work-shop-list"])]), r(i, { direction: "vertical", style: F(`height: ${l(Te)}px`) }, null, 8, ["style"]), v("div", Wt, [v("div", null, [q.value ? y("", true) : (c(), R("div", Gt, [r(l(Bt), { ref_key: "headRef", ref: le, onLoad: Qe, onChange: Ue }, { searchRight: s(() => [r(D, { shadow: "always" }, { default: s(() => [l(x)(l(S).nestingSave) ? (c(), _(n, { key: 0, type: "success", class: "filter-item", icon: "el-icon-plus", size: "default", disabled: !g.value.length, onClick: Ze }, { default: s(() => e[8] || (e[8] = [m(" 添加套料 ")])), _: 1, __: [8] }, 8, ["disabled"])) : y("", true), l(x)(l(S).noNestingSave) ? (c(), _(n, { key: 1, type: "primary", class: "filter-item", size: "default", icon: "el-icon-plus", disabled: !g.value.length, onClick: tt }, { default: s(() => e[9] || (e[9] = [m(" 直接排产 ")])), _: 1, __: [9] }, 8, ["disabled"])) : y("", true), r(n, { type: "danger", class: "filter-item", size: "default", icon: "el-icon-plus", disabled: !g.value.length, onClick: lt }, { default: s(() => e[10] || (e[10] = [m(" 零件剔除 ")])), _: 1, __: [10] }, 8, ["disabled"]), v("span", Kt, [r(d, { value: f.value.length, offset: [10, 5], hidden: !f.value.length, style: F({ marginRight: f.value.length ? "25px" : 0 }) }, { default: s(() => [l(x)(l(S).nestingSave) ? (c(), _(n, { key: 0, type: "success", class: "filter-item", icon: "el-icon-document", size: "default", round: "", plain: "", disabled: !f.value.length, onClick: et }, { default: s(() => e[11] || (e[11] = [m(" 套料明细 ")])), _: 1, __: [11] }, 8, ["disabled"])) : y("", true)]), _: 1 }, 8, ["value", "hidden", "style"]), r(d, { value: h.value.length, hidden: !h.value.length, style: F({ marginRight: h.value.length ? "25px" : 0 }) }, { default: s(() => [l(x)(l(S).noNestingSave) ? (c(), _(n, { key: 0, type: "primary", class: "filter-item", icon: "el-icon-document", size: "default", round: "", plain: "", disabled: !h.value.length, onClick: at }, { default: s(() => e[12] || (e[12] = [m(" 直接排产 ")])), _: 1, __: [12] }, 8, ["disabled"])) : y("", true)]), _: 1 }, 8, ["value", "hidden", "style"]), r(d, { value: b.value.length, hidden: !b.value.length, style: F({ marginRight: b.value.length ? "25px" : 0 }) }, { default: s(() => [l(x)(l(S).unProductDel) ? (c(), _(n, { key: 0, type: "danger", class: "filter-item", size: "default", icon: "el-icon-delete", round: "", plain: "", onClick: nt }, { default: s(() => e[13] || (e[13] = [m(" 零件剔除 ")])), _: 1, __: [13] })) : y("", true)]), _: 1 }, 8, ["value", "hidden", "style"]), l(x)(l(S).unProductDelRecord) ? (c(), _(n, { key: 0, type: "info", class: "filter-item", size: "default", icon: "el-icon-refresh-left", onClick: e[0] || (e[0] = (a) => ee.value = true), style: { float: "right" } }, { default: s(() => e[14] || (e[14] = [m(" 剔除记录 ")])), _: 1, __: [14] })) : y("", true)])]), _: 1 })]), optLeft: s(() => {
      var a, T;
      return [v("div", Yt, [r(E, { modelValue: G.value, "onUpdate:modelValue": e[1] || (e[1] = (N) => G.value = N), options: l(Nt).ENUM, showOptionAll: "", type: "enum", class: "filter-item", onChange: Ye }, null, 8, ["modelValue", "options"]), r(n, { loading: te.value, type: "danger", disabled: !((T = (a = l(o).query) == null ? void 0 : a.taskOrderIds) != null && T.length), class: "filter-item", size: "default", onClick: Xe }, { default: s(() => e[15] || (e[15] = [m(" 手动处理下发中零件 ")])), _: 1, __: [15] }, 8, ["loading", "disabled"])]), e[16] || (e[16] = v("div", null, [v("span", { class: "tips" }, "*下发失败数据，请检查图纸！")], -1))];
    }), viewLeft: s(() => {
      var a, T;
      return [r(se, { size: "large", effect: "plain", style: { "margin-right": "5px" } }, { default: s(() => {
        var N;
        return [m(" 总数量(件)：" + w(((N = L.value) == null ? void 0 : N.totalSchedulingQuantity) || 0), 1)];
      }), _: 1 }), r(se, { size: "large", effect: "plain", style: { "margin-right": "10px" } }, { default: s(() => {
        var N;
        return [m(" 总重量(kg)：" + w(l(Pt)((N = L.value) == null ? void 0 : N.totalNeedWeight) || 0), 1)];
      }), _: 1 }), r(n, { type: "primary", icon: "el-icon-document", size: "default", onClick: e[2] || (e[2] = (N) => He(0)), disabled: !g.value.length, style: { "margin-right": "10px" } }, { default: s(() => e[17] || (e[17] = [m(" 批量覆盖 ")])), _: 1, __: [17] }, 8, ["disabled"]), l(x)(l(S).downFile) ? (c(), _(Ct, { key: 0, fn: l(Rt), params: { ...l(o).query, workshopIds: Re.value }, class: "filter-item", type: "warning", icon: "el-icon-download", disabled: !((T = (a = l(o).query) == null ? void 0 : a.taskOrderIds) != null && T.length) }, { default: s(() => e[18] || (e[18] = [m(" 下载清单 ")])), _: 1, __: [18] }, 8, ["fn", "params", "disabled"])) : y("", true)];
    }), _: 1 }, 512)])), q.value ? (c(), R("div", Jt, [r(st, { column: 3, size: "large", border: "" }, { default: s(() => [r(re, { align: "center", label: "工单号：" }, { default: s(() => {
      var a;
      return [m(w(((a = l(o).data[0]) == null ? void 0 : a.orderNumber) || "-"), 1)];
    }), _: 1 }), r(re, { align: "center", label: "排产人：" }, { default: s(() => {
      var a;
      return [m(w(((a = l(o).data[0]) == null ? void 0 : a.userName) || "-"), 1)];
    }), _: 1 }), r(re, { align: "center", label: "排产日期：" }, { default: s(() => {
      var a;
      return [m(w(((a = l(o).data[0]) == null ? void 0 : a.schedulingDate) || "-"), 1)];
    }), _: 1 })]), _: 1 })])) : y("", true), ue(r(se, { type: "info", size: "large" }, { default: s(() => e[19] || (e[19] = [m(" * 请先选择项目或者班组进行零件排产 ")])), _: 1, __: [19] }, 512), [[de, !((_e = (ye = l(o).query) == null ? void 0 : ye.taskOrderIds) != null && _e.length)]]), ue((c(), _(ut, { ref_key: "tableRef", ref: P, data: l(o).data, "show-summary": "", "summary-method": ot, "empty-text": l(o).emptyText, "max-height": l(De), style: { width: "100%" }, id: "listTable", showEmptySymbol: false, "row-class-name": Oe, "cell-class-name": Be, onSelectionChange: Fe }, { default: s(() => [q.value ? y("", true) : (c(), _(k, { key: 0, type: "selection", width: "55", align: "center", selectable: qe })), r(k, { key: "orderNumber", prop: "orderNumber", label: "工单号", "min-width": "180", align: "center", "show-overflow-tooltip": true }, { default: s(({ row: a }) => [a.issuedToNestingSoftwareStatus === l(V).ISSUED_IN_PROGRESS.V || a.issuedToNestingSoftwareStatus === l(V).ISSUANCE_FAILED.V ? (c(), _(he, { key: 0, name: l(V).VL[a.issuedToNestingSoftwareStatus], color: "#e64242", offset: 15 }, null, 8, ["name"])) : y("", true), v("span", null, w(a.orderNumber), 1)]), _: 1 }), r(k, { key: "partType", prop: "partType", label: "零件类型", align: "center" }, { default: s((a) => [v("span", null, w(a.row.partType || "-"), 1)]), _: 1 }), r(k, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center" }, { default: s((a) => [a.row.boolSendDirectly ? (c(), _(he, { key: 0, name: l(Ne).VL[a.row.boolSendDirectly], color: l(Ne).V[a.row.boolSendDirectly].COLOR, offset: 15 }, null, 8, ["name", "color"])) : y("", true), v("span", null, w(a.row.serialNumber || "-"), 1)]), _: 1 }), r(k, { key: "material", prop: "material", label: "材质", align: "center", width: "100", "show-overflow-tooltip": "" }, { default: s((a) => [v("span", null, w(a.row.material || "-"), 1)]), _: 1 }), r(k, { key: "thick", prop: "thick", label: "厚度", align: "center" }, { default: s((a) => [v("span", null, w(a.row.thick ?? "-"), 1)]), _: 1 }), r(k, { key: "width", prop: "width", label: "宽度", align: "center" }, { default: s((a) => [v("span", null, w(a.row.width ?? "-"), 1)]), _: 1 }), r(k, { key: "length", prop: "length", label: "长度", align: "center" }, { default: s((a) => [v("span", null, w(a.row.length ?? "-"), 1)]), _: 1 }), r(k, { key: "quantity", prop: "quantity", label: "数量", align: "center" }, { default: s((a) => [v("span", null, w(a.row.quantity ?? "-"), 1)]), _: 1 }), r(k, { key: "weight", prop: "weight", label: "重量", align: "center" }), r(k, { key: "picturePath", prop: "picturePath", label: "缩略图", align: "center", "min-width": "120" }, { default: s((a) => [r(rt, { placement: "top", effect: "light", ref: "tooltip", "show-after": 300 }, { content: s(() => [r(ge, { style: { width: "200px", height: "200px" }, fit: "scale-down", "scroll-container": "#listTable .el-table__body-wrapper", src: `${a.row.picturePath}` }, { error: s(() => [v("div", Xt, [a.row.picturePath ? (c(), R("span", Zt, "加载失败")) : (c(), R("span", ea, "未导入DXF"))])]), _: 2 }, 1032, ["src"])]), default: s(() => [r(ge, { style: { width: "100%", height: "20px" }, fit: "scale-down", "scroll-container": "#listTable .el-table__body-wrapper", src: `${a.row.picturePath || null}` }, { error: s(() => [v("div", ta, [a.row.picturePath ? (c(), R("span", aa, "加载失败")) : (c(), R("span", la, "未导入DXF"))])]), _: 2 }, 1032, ["src"])]), _: 2 }, 1536)]), _: 1 }), q.value ? y("", true) : (c(), _(k, { key: 1, label: "操作", width: "160", align: "center", fixed: "right" }, { default: s(({ row: a }) => [l(x)(l(S).downFile) ? (c(), _(Ft, { key: 0, dataType: 2, accept: ".dxf", data: Me(a), "upload-fun": l(Lt), uploadFunFile: l(qt), tip: ".dxf", "btn-name": "替换", size: "default", type: "primary", onSuccess: l(o).toQuery }, null, 8, ["data", "upload-fun", "uploadFunFile", "onSuccess"])) : y("", true), l(x)(l(S).downFile) ? (c(), _(n, { key: 1, class: "filter-item", type: "primary", onClick: (T) => Ae(a), disabled: !a.drwaingId, style: { margin: "5px" } }, { default: s(() => e[20] || (e[20] = [m("下载")])), _: 2, __: [20] }, 1032, ["onClick", "disabled"])) : y("", true)]), _: 1 }))]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[de, (we = (be = l(o).query) == null ? void 0 : be.taskOrderIds) == null ? void 0 : we.length], [dt, l(o).loading]]), ue(r(l(Dt), { pageSizes: [10, 20, 30, 40, 50, 100, 200, 500, 1e3] }, null, 512), [[de, (Se = (ke = l(o).query) == null ? void 0 : ke.taskOrderIds) == null ? void 0 : Se.length]]), r(l(At), { visible: z.value, "onUpdate:visible": e[3] || (e[3] = (a) => z.value = a), list: C.value, type: Y.value, "checked-nodes": B.value, "pad-block-data": H.value, onSuccess: Ge, onHandleDel: ne, onHandleBatchDel: ie, "thick-list": $.value, "material-list": W.value, thick: l(o).query.thick, material: l(o).query.material, "thick-data": l(o).query.thickList }, null, 8, ["visible", "list", "type", "checked-nodes", "pad-block-data", "thick-list", "material-list", "thick", "material", "thick-data"]), r(l(Mt), { visible: me.value, "onUpdate:visible": e[4] || (e[4] = (a) => me.value = a), "pad-block-data": H.value, onAddBlock: it }, null, 8, ["visible", "pad-block-data"]), r(l(Ht), { visible: M.value, "onUpdate:visible": e[5] || (e[5] = (a) => M.value = a), info: Z.value, eliminateList: b.value, onClose: ze, onSuccess: We, onHandleDel: ne, onHandleBatchDel: ie }, null, 8, ["visible", "info", "eliminateList"]), r(l(Ut), { visible: ee.value, "onUpdate:visible": e[6] || (e[6] = (a) => ee.value = a), onRefresh: l(o).refresh, projectId: O.value }, null, 8, ["visible", "onRefresh", "projectId"]), r(l(Qt), { visible: J.value, "onUpdate:visible": e[7] || (e[7] = (a) => J.value = a), rePictureList: I.value, projectId: O.value, onHandleDel: ne, onHandleBatchDel: ie, onPictureState: Ke }, null, 8, ["visible", "rePictureList", "projectId"])])])]);
  };
} }, Ca = St(na, [["__scopeId", "data-v-9a33d8ca"]]);
export {
  Ca as default
};
