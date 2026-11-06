import { ref as G } from "vue";
import { inject as Le } from "vue";
import { computed as V } from "vue";
import { watch as me } from "vue";
import { resolveComponent as pe } from "vue";
import { openBlock as s } from "vue";
import { createBlock as v } from "vue";
import { withCtx as r } from "vue";
import { createVNode as b } from "vue";
import { createTextVNode as fe } from "vue";
import { toDisplayString as c } from "vue";
import { unref as o } from "vue";
import { createCommentVNode as w } from "vue";
import { createElementVNode as p } from "vue";
import { createElementBlock as A } from "vue";
import { Fragment as J } from "vue";
import { renderList as Y } from "vue";
import { isRef as Pe } from "vue";
import { ElMessageBox as Se } from "element-plus";
import { ElMessage as Oe } from "element-plus";
import { ElTag as Re } from "element-plus";
import { ElDescriptionsItem as qe } from "element-plus";
import { InfoFilled as Ue } from "@element-plus/icons-vue";
import { ElIcon as Me } from "element-plus";
import { ElTooltip as Qe } from "element-plus";
import { ElOption as Fe } from "element-plus";
import { ElSelect as ze } from "element-plus";
import { ElDescriptions as Be } from "element-plus";
import { q as xe, a as je, d as We, e as He, f as Ge, h as Je } from "../../../../../modules/reporting-approval-2b65eecd.js";
import { _ as Ye, m as $e, u as Ke, a3 as C, qb as Xe, qa as Ze, q9 as et, cf as ve, qc as tt, G as at, qd as nt, f9 as lt, p as ut, i as rt, e0 as ot, e1 as it, bV as be, aY as st, qe as M } from "../../../../../shared/runtime.js";
import { u as ct } from "../../../../../modules/use-drawing-8a7ba23b.js";
import { b as dt } from "../../../../../modules/bim-preview-drawer-7ca7893b.js";
import { a as mt } from "../../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import { _ as pt } from "../../../../../modules/index-c07af747.js";
import { u as ft } from "../../../../../modules/use-production-team-d8043fd6.js";
import "../../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../../modules/model-0ac957f7.js";
import "../../../../../modules/index-d6a37d29.js";
import "../../../../../modules/use-chart-59e4b63c.js";
import "../../../../../modules/index-18acf776.js";
const vt = { key: 0, class: "ellipsis" }, bt = { key: 0 }, gt = { key: 1 }, yt = { key: 0 }, Tt = { __name: "detail", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, currentDetail: { type: Object, default: () => {
} }, viewType: { type: [Number, String], default: null } }, emits: ["update:modelValue", "success"], setup(m, { emit: ge }) {
  const Z = ge, { loaded: ee, productionTeam: $ } = ft(), y = m, { user: ye } = $e("user"), { visible: K, handleClose: te } = Ke({ emit: Z, props: y, showHook: _e, closeHook: Ve }), { showDrawing: ae, drawingRow: T, drawingPreview: Te } = ct({ pidField: "productId", typeField: "productTypeEnum" }), X = G([]), j = G(false), W = G(false), l = G(), ne = Le("wageDisplayPrecision"), L = V(() => {
    var a;
    return ((a = y.currentRow) == null ? void 0 : a.productTypeEnum) === C.ARTIFACT.V;
  }), Q = V(() => {
    var a;
    return ((a = y.currentRow) == null ? void 0 : a.productTypeEnum) === C.ASSEMBLE.V;
  });
  V(() => {
    var a;
    return ((a = y.currentRow) == null ? void 0 : a.productTypeEnum) === C.MACHINE_PART.V;
  });
  const k = V(() => {
    var a;
    return ((a = y.currentRow) == null ? void 0 : a.productTypeEnum) === C.ENCLOSURE.V;
  }), we = V(() => {
    var a;
    switch ((a = y.currentRow) == null ? void 0 : a.productTypeEnum) {
      case C.ARTIFACT.V:
        return et;
      case C.ASSEMBLE.V:
        return Ze;
      case C.MACHINE_PART.V:
        return Xe;
      default:
        return {};
    }
  }), Ee = V(() => {
    var a, e, d;
    if (((e = (a = y.currentRow) == null ? void 0 : a.process) == null ? void 0 : e.type) === ve.PAINT.V) return xe;
    switch ((d = y.currentRow) == null ? void 0 : d.productTypeEnum) {
      case C.ARTIFACT.V:
        return He;
      case C.ASSEMBLE.V:
        return We;
      case C.MACHINE_PART.V:
        return je;
      default:
        return null;
    }
  });
  me([() => j.value, () => W.value], ([a, e]) => {
    !a && !e && (ae.value = false);
  }), me(() => ae.value, (a) => {
    var e, d, f, u;
    a && ((e = T.value) != null && e.productType && ((d = T.value) == null ? void 0 : d.productType) & C.ARTIFACT.V && (j.value = true), (f = T.value) != null && f.productType && !(((u = T.value) == null ? void 0 : u.productType) & C.ARTIFACT.V) && (W.value = true));
  });
  function Ie(a) {
    var e, d;
    l.value.teamOrganizationType = ((d = (e = $.value) == null ? void 0 : e.find((f) => f.id === a)) == null ? void 0 : d.organizationType) || void 0, oe(l.value.quotaConfigSerialNumber), l.value.reportPersonId = void 0;
  }
  const Ce = V(() => y.viewType === tt.REAL_TIME_WORK_REPORTING.V ? Ge : Je), le = V(() => $.value.filter((a) => {
    var e, d;
    return a.workshopId === ((e = l.value) == null ? void 0 : e.workshopId) && a.processId === ((d = l.value) == null ? void 0 : d.processId);
  }) || []), ue = V(() => {
    var a;
    return ((a = $.value.find((e) => e.id === l.value.teamId)) == null ? void 0 : a.userLinkList) || [];
  });
  function ke(a) {
    l.value.teamId = void 0, l.value.quotaConfigSerialNumber = void 0, l.value.conditionList = void 0, l.value.measureUnit = void 0, l.value.price = void 0, l.value.amount = void 0, k.value || re();
  }
  async function re() {
    var a, e, d, f, u, N, D, P, h, S, F, B, E, _, O, q, z;
    try {
      const U = { workshopId: ((a = l.value) == null ? void 0 : a.workshopId) || void 0, branchCompanyId: ((e = y.currentDetail) == null ? void 0 : e.branchCompanyId) || void 0, productClassId: ((f = (d = y.currentDetail) == null ? void 0 : d.product) == null ? void 0 : f.classId) || void 0, processId: ((N = (u = y.currentDetail) == null ? void 0 : u.process) == null ? void 0 : N.id) || void 0, productClassificationEnumList: (P = (D = y.currentDetail) == null ? void 0 : D.product) != null && P.productClassificationEnum ? [(S = (h = y.currentDetail) == null ? void 0 : h.product) == null ? void 0 : S.productClassificationEnum] : void 0 }, x = { workshopId: ((F = l.value) == null ? void 0 : F.workshopId) || void 0, branchCompanyId: ((B = y.currentDetail) == null ? void 0 : B.branchCompanyId) || void 0, productClassId: ((_ = (E = y.currentDetail) == null ? void 0 : E.product) == null ? void 0 : _.classId) || void 0 }, R = await Ee.value(((q = (O = y.currentRow) == null ? void 0 : O.process) == null ? void 0 : q.id) === 34 ? x : U);
      X.value = R || [], l.value.conditionList = ((z = R == null ? void 0 : R.find((H) => H.serialNumber === l.value.quotaConfigSerialNumber)) == null ? void 0 : z.conditionList) || [];
    } catch (U) {
      console.log(U);
    }
  }
  function oe(a) {
    var N;
    const e = ((N = X.value) == null ? void 0 : N.find((D) => D.serialNumber === a)) || {};
    l.value.conditionList = (e == null ? void 0 : e.conditionList) || [], l.value.quotaMatchingCondition = JSON.stringify((e == null ? void 0 : e.conditionList) || {}), l.value.measureUnit = (e == null ? void 0 : e.measureUnit) || "", l.value.quotaConfigId = (e == null ? void 0 : e.id) || void 0;
    const d = Ne(l.value, e);
    l.value.price = (d == null ? void 0 : d.toFixed(2)) || null;
    const f = he(l.value, d);
    l.value.amount = (f == null ? void 0 : f.toFixed(2)) || null;
    const u = De(l.value);
    l.value.measurementQuantity = u !== null ? Number(u) : null;
  }
  function Ne(a, e) {
    const { teamOrganizationType: d, process: f } = a, { paintFilmThicknessBase: u, startAddPaintFilmThickness: N, startOrganizationInsidePrice: D, startOrganizationOutsidePrice: P, startAddOrganizationInsidePrice: h, startAddOrganizationOutsidePrice: S, organizationInsidePrice: F, organizationOutsidePrice: B } = e;
    if ((f == null ? void 0 : f.type) !== ve.PAINT.V || !d) return null;
    const E = d === st.IN_STAFF.V, _ = E ? "organizationInsidePrice" : "organizationOutsidePrice";
    if (e[_] !== void 0 && e[_] !== null) return e[_];
    const O = a.paintFilmThickness || 0;
    if (O <= u) return E ? D : P;
    const q = O - u;
    return Math.ceil(q / N) * (E ? h : S) + (E ? D : P);
  }
  function he(a, e) {
    if (e === null) return null;
    console.log(a.measurementQuantity, "detail.measurementQuantitydetail.measurementQuantity");
    const d = Number(a.reportQuantity) || 0, f = Number(a.measurementQuantity) || 0, u = a.product || {};
    switch (a.measureUnit) {
      case M.TON.L:
        return d * ((u.netWeight || 0) / 1e3) * e;
      case M.METER.L:
        return d * ((u.length || 0) / 1e3) * e;
      case M.PIECE.L:
        return d * e;
      case M.SQUARE_METER.L:
        return f * e;
      default:
        return null;
    }
  }
  function De(a) {
    const e = Number(a.reportQuantity) || 0, d = Number(a.measurementQuantity) || 0, f = a.product || {};
    switch (a.measureUnit) {
      case M.TON.L:
        return e * ((Number(f.netWeight) || 0) / 1e3);
      case M.METER.L:
        return e * ((Number(f.length) || 0) / 1e3);
      case M.PIECE.L:
        return e;
      default:
        return d;
    }
  }
  function _e() {
    l.value = JSON.parse(JSON.stringify(y.currentDetail || {})), k.value || re();
  }
  function Ve() {
  }
  async function Ae() {
    try {
      await Se.confirm("是否确认通过？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await Ce.value(l.value), Oe.success("通过成功！"), te(), Z("success");
    } catch (a) {
      console.log(a);
    }
  }
  return (a, e) => {
    const d = Re, f = pe("common-button"), u = qe, N = Ue, D = Me, P = Qe, h = Fe, S = ze, F = Be, B = pe("common-drawer");
    return s(), v(B, { ref: "drawerRef", "append-to-body": "", modelValue: o(K), "onUpdate:modelValue": e[7] || (e[7] = (E) => Pe(K) ? K.value = E : null), "before-close": o(te), "close-on-click-modal": false, title: "工价审核", size: "30%", "custom-class": "reporting-approval-detail" }, { titleAfter: r(() => [b(d, { size: "large" }, { default: r(() => {
      var E;
      return [fe("审核：" + c(((E = o(ye)) == null ? void 0 : E.name) || "-"), 1)];
    }), _: 1 })]), titleRight: r(() => [o(at)(o(nt).passTheAudit) ? (s(), v(f, { key: 0, type: "success", size: "default", onClick: Ae }, { default: r(() => e[8] || (e[8] = [fe(" 通过 ")])), _: 1, __: [8] })) : w("", true)]), content: r(() => {
      var E, _, O, q, z, U, x, R, H, ie, se, ce, de;
      return [b(F, { data: l.value, column: 1, size: "large", border: "" }, { default: r(() => [b(u, { align: "center", label: "项目" }, { default: r(() => {
        var t, n, g, i;
        return [p("span", null, c((n = (t = m.currentDetail) == null ? void 0 : t.project) == null ? void 0 : n.serialNumber) + " - " + c((i = (g = m.currentDetail) == null ? void 0 : g.project) == null ? void 0 : i.shortName), 1)];
      }), _: 1 }), L.value || Q.value ? (s(), v(u, { key: 0, align: "center", label: "单体/区域" }, { default: r(() => {
        var t, n, g, i;
        return [p("span", null, c((n = (t = m.currentDetail) == null ? void 0 : t.monomer) == null ? void 0 : n.name) + " / " + c((i = (g = m.currentDetail) == null ? void 0 : g.area) == null ? void 0 : i.name), 1)];
      }), _: 1 })) : w("", true), L.value || Q.value ? (s(), v(u, { key: 1, align: "center", label: "批次" }, { default: r(() => {
        var t, n;
        return [p("span", null, c(((n = (t = m.currentDetail) == null ? void 0 : t.areaBatch) == null ? void 0 : n.name) || "-"), 1)];
      }), _: 1 })) : w("", true), L.value ? (s(), v(u, { key: 2, align: "center", label: "主次构件类型" }, { default: r(() => {
        var t, n;
        return [p("span", null, c(o(lt).VL[(n = (t = m.currentDetail) == null ? void 0 : t.product) == null ? void 0 : n.productClassificationEnum] || "-"), 1)];
      }), _: 1 })) : w("", true), L.value || Q.value ? (s(), v(u, { key: 3, align: "center", label: "名称" }, { default: r(() => {
        var t, n;
        return [p("span", null, c(((n = (t = m.currentDetail) == null ? void 0 : t.product) == null ? void 0 : n.name) || "-"), 1)];
      }), _: 1 })) : w("", true), k.value ? (s(), v(u, { key: 4, align: "center", label: "围护类型" }, { default: r(() => {
        var t, n;
        return [p("span", null, c(((n = (t = m.currentDetail) == null ? void 0 : t.dict) == null ? void 0 : n.label) || "-"), 1)];
      }), _: 1 })) : w("", true), b(u, { align: "center", label: "编号" }, { label: r(() => [b(P, { effect: "light", content: "双击编号可预览图纸", placement: "top" }, { default: r(() => [e[9] || (e[9] = p("span", null, "编号", -1)), b(D, null, { default: r(() => [b(N)]), _: 1 })]), _: 1, __: [9] })]), default: r(() => {
        var t, n, g;
        return [k.value ? (s(), v(P, { key: 0, content: ((t = m.currentDetail) == null ? void 0 : t.productSerialNumbers) || "-", placement: "top" }, { default: r(() => {
          var i;
          return [k.value ? (s(), A("span", vt, c(((i = m.currentDetail) == null ? void 0 : i.productSerialNumbers) || "-"), 1)) : w("", true)];
        }), _: 1 }, 8, ["content"])) : (s(), A("span", { key: 1, style: { cursor: "pointer", color: "#409eff" }, onDblclick: e[0] || (e[0] = (i) => o(Te)(m.currentDetail)) }, c(((g = (n = m.currentDetail) == null ? void 0 : n.product) == null ? void 0 : g.serialNumber) || "-"), 33))];
      }), _: 1 }), L.value || Q.value ? (s(), v(u, { key: 5, align: "center", label: "规格" }, { default: r(() => {
        var t, n;
        return [p("span", null, c(((n = (t = m.currentDetail) == null ? void 0 : t.product) == null ? void 0 : n.specification) || "-"), 1)];
      }), _: 1 })) : w("", true), L.value || Q.value ? (s(), v(u, { key: 6, align: "center", label: "单净重（kg）" }, { default: r(() => {
        var t, n;
        return [p("span", null, c(((n = (t = m.currentDetail) == null ? void 0 : t.product) == null ? void 0 : n.netWeight) || "-"), 1)];
      }), _: 1 })) : w("", true), L.value || Q.value ? (s(), v(u, { key: 7, align: "center", label: "单长度（mm）" }, { default: r(() => {
        var t, n;
        return [p("span", null, c(((n = (t = m.currentDetail) == null ? void 0 : t.product) == null ? void 0 : n.length) || "-"), 1)];
      }), _: 1 })) : w("", true), L.value ? (s(), v(u, { key: 8, align: "center", label: "构件类型" }, { default: r(() => {
        var t, n;
        return [p("span", null, c(((n = (t = m.currentDetail) == null ? void 0 : t.product) == null ? void 0 : n.className) || "-"), 1)];
      }), _: 1 })) : w("", true), k.value ? (s(), v(u, { key: 9, align: "center", label: "上报数（张数/总长度（米））" }, { default: r(() => {
        var t, n, g, i;
        return [k.value ? (s(), A("span", bt, c((t = m.currentDetail) == null ? void 0 : t.reportQuantity) + " / " + c((n = m.currentDetail) == null ? void 0 : n.measurementQuantity), 1)) : (s(), A("span", gt, c((g = m.currentDetail) == null ? void 0 : g.reportQuantity) + " / " + c((i = m.currentDetail) == null ? void 0 : i.reportWeight), 1))];
      }), _: 1 })) : w("", true), b(u, { align: "center", label: "车间" }, { default: r(() => [b(o(pt), { modelValue: l.value.workshopId, "onUpdate:modelValue": e[1] || (e[1] = (t) => l.value.workshopId = t), placeholder: "车间筛选", class: "filter-item", style: { width: "100%" }, onChange: ke }, null, 8, ["modelValue"])]), _: 1 }), b(u, { align: "center", label: "班组" }, { default: r(() => [b(S, { modelValue: l.value.teamId, "onUpdate:modelValue": e[2] || (e[2] = (t) => l.value.teamId = t), placeholder: "请选择班组", size: "default", disabled: !o(ee), style: { width: "100%" }, onChange: Ie }, { default: r(() => {
        var t, n, g, i;
        return [le.value.length ? w("", true) : (s(), v(h, { key: 0, label: (n = (t = l.value) == null ? void 0 : t.team) == null ? void 0 : n.name, value: (i = (g = l.value) == null ? void 0 : g.team) == null ? void 0 : i.id }, null, 8, ["label", "value"])), (s(true), A(J, null, Y(le.value, (I) => (s(), v(h, { key: I.id, label: I.label, value: I.id }, null, 8, ["label", "value"]))), 128))];
      }), _: 1 }, 8, ["modelValue", "disabled"])]), _: 1 }), b(u, { align: "center", label: "上报人" }, { default: r(() => [b(S, { modelValue: l.value.reportPersonId, "onUpdate:modelValue": e[3] || (e[3] = (t) => l.value.reportPersonId = t), placeholder: "请选择班组", size: "default", disabled: !o(ee), style: { width: "100%" } }, { default: r(() => {
        var t, n, g, i;
        return [ue.value.length ? w("", true) : (s(), v(h, { key: 0, label: (n = (t = l.value) == null ? void 0 : t.reportPerson) == null ? void 0 : n.name, value: (i = (g = l.value) == null ? void 0 : g.reportPerson) == null ? void 0 : i.id }, null, 8, ["label", "value"])), (s(true), A(J, null, Y(ue.value, (I) => (s(), v(h, { key: I.userId, label: I.userName, value: I.userId }, null, 8, ["label", "value"]))), 128))];
      }), _: 1 }, 8, ["modelValue", "disabled"])]), _: 1 }), k.value ? w("", true) : (s(), v(u, { key: 10, align: "center", label: "工序" }, { default: r(() => {
        var t, n;
        return [p("span", null, c(((n = (t = m.currentDetail) == null ? void 0 : t.process) == null ? void 0 : n.name) || "-"), 1)];
      }), _: 1 })), k.value ? w("", true) : (s(), v(u, { key: 11, align: "center", label: "上报数（数量/重量）" }, { default: r(() => {
        var t, n;
        return [p("span", null, c((t = m.currentDetail) == null ? void 0 : t.reportQuantity) + " / " + c((n = m.currentDetail) == null ? void 0 : n.reportWeight), 1)];
      }), _: 1 })), b(u, { align: "center", label: "上报日期" }, { default: r(() => {
        var t;
        return [p("span", null, c((t = m.currentDetail) != null && t.reportDate ? o(ut)(m.currentDetail.reportDate, "{y}-{m}-{d}") : "-"), 1)];
      }), _: 1 })]), _: 1 }, 8, ["data"]), e[11] || (e[11] = p("div", { class: "partition" }, [p("span", null, "定额单价构成")], -1)), b(F, { data: l.value, column: 1, size: "large", border: "" }, { default: r(() => {
        var t, n, g;
        return [b(u, { align: "center", label: "执行定额编号" }, { default: r(() => {
          var i;
          return [k.value ? (s(), A("span", yt, c(((i = l.value) == null ? void 0 : i.quotaConfigSerialNumber) || "-"), 1)) : (s(), v(S, { key: 1, modelValue: l.value.quotaConfigSerialNumber, "onUpdate:modelValue": e[4] || (e[4] = (I) => l.value.quotaConfigSerialNumber = I), placeholder: "执行定额编号", size: "default", style: { width: "100%" }, onChange: oe }, { default: r(() => [(s(true), A(J, null, Y(X.value, (I) => (s(), v(h, { key: I.serialNumber, label: I.serialNumber, value: I.serialNumber }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"]))];
        }), _: 1 }), ((n = (t = l.value) == null ? void 0 : t.conditionList) == null ? void 0 : n.length) > 0 && o(rt)(m.currentRow) ? (s(true), A(J, { key: 0 }, Y((g = l.value) == null ? void 0 : g.conditionList, (i) => (s(), v(u, { key: i.id, align: "center", label: we.value.VL[i.conditionEnum] }, { default: r(() => [p("span", null, c(i.numberOne), 1), p("span", null, c(o(ot).VL[i.comparisonOperatorOne]), 1), e[10] || (e[10] = p("span", null, " X ", -1)), p("span", null, c(o(it).VL[i.comparisonOperatorTwo]), 1), p("span", null, c(i.numberTwo), 1)]), _: 2, __: [10] }, 1032, ["label"]))), 128)) : w("", true), b(u, { align: "center", label: "计量单位" }, { default: r(() => {
          var i;
          return [p("span", null, c(((i = l.value) == null ? void 0 : i.measureUnit) || "-"), 1)];
        }), _: 1 }), b(u, { align: "center", label: "单价（元）" }, { default: r(() => [p("span", null, c(o(be)(l.value.price, o(ne)) ?? "-"), 1)]), _: 1 }), b(u, { align: "center", label: "金额（元）" }, { default: r(() => [p("span", null, c(o(be)(l.value.amount, o(ne)) ?? "-"), 1)]), _: 1 })];
      }), _: 1 }, 8, ["data"]), b(o(dt), { visible: j.value, "onUpdate:visible": e[5] || (e[5] = (t) => j.value = t), "bool-bim": (E = o(T)) == null ? void 0 : E.boolBim, drawingSN: (_ = o(T)) == null ? void 0 : _.drawingSN, "monomer-id": (O = o(T)) == null ? void 0 : O.monomerId, "serial-number": (q = o(T)) == null ? void 0 : q.serialNumber, productId: (z = o(T)) == null ? void 0 : z.productId, productType: (U = o(T)) == null ? void 0 : U.productType, projectType: (x = o(T)) == null ? void 0 : x.projectType }, null, 8, ["visible", "bool-bim", "drawingSN", "monomer-id", "serial-number", "productId", "productType", "projectType"]), b(o(mt), { modelValue: W.value, "onUpdate:modelValue": e[6] || (e[6] = (t) => W.value = t), drawingSN: (R = o(T)) == null ? void 0 : R.drawingSN, "bool-bim": (H = o(T)) == null ? void 0 : H.boolBim, "serial-number": (ie = o(T)) == null ? void 0 : ie.serialNumber, productId: (se = o(T)) == null ? void 0 : se.productId, productType: (ce = o(T)) == null ? void 0 : ce.productType, "monomer-id": (de = o(T)) == null ? void 0 : de.monomerId }, null, 8, ["modelValue", "drawingSN", "bool-bim", "serial-number", "productId", "productType", "monomer-id"])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ot = Ye(Tt, [["__scopeId", "data-v-668512b2"]]);
export {
  Ot as default
};
