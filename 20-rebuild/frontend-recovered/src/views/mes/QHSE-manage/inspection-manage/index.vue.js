import { ref as i } from "vue";
import { provide as ne } from "vue";
import { computed as xe } from "vue";
import { reactive as be } from "vue";
import { watch as le } from "vue";
import N from "moment";
import { onMounted as Be } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as h } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as n } from "vue";
import { unref as g } from "vue";
import { createBlock as b } from "vue";
import { withCtx as a } from "vue";
import { createTextVNode as B } from "vue";
import { createCommentVNode as E } from "vue";
import { withDirectives as Ie } from "vue";
import { normalizeStyle as ke } from "vue";
import { normalizeClass as Ve } from "vue";
import { toDisplayString as x } from "vue";
import { withModifiers as he } from "vue";
import { ElCol as Ee } from "element-plus";
import { ElRow as we } from "element-plus";
import { ElDatePicker as Le } from "element-plus";
import { ElButton as Ae } from "element-plus";
import { ElButtonGroup as Me } from "element-plus";
import { ElTag as Se } from "element-plus";
import { ElCalendar as Oe } from "element-plus";
import { vLoading as De } from "element-plus";
import { P as Ne } from "../../../../modules/index-5b9e6004.js";
import { g as Re, a as je, b as ze } from "../../../../modules/inspection-manage-c10227da.js";
import { _ as Ue, m as Te, mL as ae, n as $e, mM as C, o as He, i as j, p as se, G as I } from "../../../../shared/runtime.js";
import Pe from "./inspection-config/index.vue.js";
import Ye from "./module/day-detail.vue.js";
import { C as Fe } from "../../../../modules/index-d6a37d29.js";
import Ge from "./module/history-map-dialog.vue.js";
import qe from "./module/problem-report.vue.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../modules/inspection-config-a69d9e2f.js";
import "./inspection-config/module/inspection-point-dlg.vue.js";
import "../../../../modules/index-df3c71c0.js";
import "../../../../modules/PicUpload-8580ccfc.js";
import "./inspection-config/module/user-line-dlg.vue.js";
import "./inspection-config/module/qr-code-dlg.vue.js";
import "../../../../modules/index-c549a8fd.js";
import "../../../../modules/html2canvas.esm-e0a7d97b.js";
import "./inspection-config/module/personal-map-history.vue.js";
import "./inspection-config/module/audit-detail.vue.js";
import "./module/map-location-dialog.vue.js";
import "../../../../modules/index-cfd8d896.js";
const Ke = { class: "app-container" }, Qe = { class: "head-container" }, We = { class: "flex-rsc" }, Je = { style: { display: "flex", "justify-content": "flex-end" } }, Xe = ["onClick"], Ze = { style: { display: "flex", "align-items": "center" } }, et = { class: "date-info" }, tt = { key: 0, class: "routing-inspection" }, ot = { key: 1 }, nt = { key: 2 }, lt = { __name: "index", setup(at) {
  const { globalProjectId: ie } = Te(["globalProjectId"]), c = i(ae.ALL.V), d = { NORMAL: { L: "正常完成", K: "NORMAL", V: 1, C: "#BEE5CB" }, ABNORMAL: { L: "非正常完成", K: "ABNORMAL", V: 2, C: "#FFF7B0" }, ABSENCE: { L: "缺勤", K: "ABSENCE", V: 3, C: "#FDCACA" } };
  $e(d);
  const re = [{ color: d.NORMAL.C, title: d.NORMAL.L }, { color: d.ABNORMAL.C, title: d.ABNORMAL.L }, { color: d.ABSENCE.C, title: d.ABSENCE.L }];
  ne("permission", C);
  const ue = xe(() => ie.value);
  ne("projectId", ue);
  const m = i(/* @__PURE__ */ new Date()), z = i(), w = i(false), f = i({}), r = i(), L = i([]), U = i(false), T = i(false), k = i(false), A = i(false), $ = i(), H = i(), P = i(false);
  function pe() {
    const o = ["日", "一", "二", "三", "四", "五", "六"];
    document.querySelector(".el-calendar-table").querySelectorAll("th").forEach((O, v) => {
      O.textContent = o[v];
    });
  }
  const l = be({ map: {}, list: [] }), M = i(false), Y = i(), { maxHeight: ce } = He({ mainBox: ".inspection-config-drawer", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true, extraHeight: 50 }, k);
  F(), G(), V(), le([() => r.value, () => c.value], (o) => {
    F(), V();
  }, { immediate: true }), le(() => m.value, (o, e) => {
    (j(o) && j(e) && se(o, "{y}-{m}") !== se(e, "{y}-{m}") || !e) && V();
  }, { immediate: true });
  async function S(o) {
    await z.value.selectDate(o);
  }
  async function F() {
    if (f.value = {}, !(!I(C.get) || !r.value || !c.value)) try {
      w.value = true;
      const o = await Re({ userId: r.value, inspectionSiteOptionType: c.value });
      f.value = o;
    } catch (o) {
      console.log(o);
    } finally {
      w.value = false;
    }
  }
  async function G() {
    var o;
    if (L.value = [], !!I(C.get)) try {
      U.value = true;
      const e = await je();
      L.value = e == null ? void 0 : e.map((s) => ({ id: s.userId, name: s.userName })), r.value && (e == null ? void 0 : e.findIndex((s) => s.userId === r.value)) < 0 && (r.value = (o = e[0]) == null ? void 0 : o.userId);
    } catch (e) {
      console.log(e);
    } finally {
      U.value = false;
    }
  }
  async function V() {
    var o;
    if (l.list = [], l.map = {}, !(!I(C.get) || !r.value || !c.value)) try {
      T.value = true;
      const e = await ze({ userId: r.value, inspectionSiteOptionType: c.value, startDate: N(m.value).startOf("month").valueOf(), endDate: N(m.value).endOf("month").valueOf() });
      l.list = e || [], (o = l.list) == null || o.forEach((s) => {
        s.day = N(s.inspectionDate).format("YYYY-MM-DD"), l.map[s.day] = s;
      });
    } catch (e) {
      console.log(e);
    } finally {
      T.value = false;
    }
  }
  function de(o) {
    var e, s;
    I(C.detail) && ($.value = o.day, (s = (e = l.map) == null ? void 0 : e[o.day]) != null && s.projectInspectionCount && (A.value = true));
  }
  function me(o) {
    (o == null ? void 0 : o.hazardCount) > 0 && (Y.value = o, M.value = true);
  }
  return Be(() => {
    pe();
  }), (o, e) => {
    const s = R("common-radio-button"), O = R("common-button"), v = Ne, y = Ee, q = we, fe = Le, D = Ae, ve = Me, ye = Se, _e = Oe, ge = R("common-drawer"), Ce = De;
    return p(), h("div", Ke, [u("div", Qe, [n(s, { class: "filter-item", modelValue: r.value, "onUpdate:modelValue": e[0] || (e[0] = (t) => r.value = t), options: L.value, type: "other", default: "" }, null, 8, ["modelValue", "options"]), g(I)(g(C).settingGet) ? (p(), b(O, { key: 0, type: "warning", class: "filter-item", icon: "el-icon-setting", onClick: e[1] || (e[1] = (t) => k.value = true), style: { float: "right" } }, { default: a(() => e[12] || (e[12] = [B(" 巡检配置 ")])), _: 1, __: [12] })) : E("", true)]), Ie((p(), b(q, { gutter: 20, class: "panel-group" }, { default: a(() => [n(y, { span: 4, class: "card-panel-col" }, { default: a(() => [n(v, { name: "年度正常完成数", "text-color": "#626262", "num-color": "#FCC90B", "end-val": f.value.normalCompletionByYear || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), n(y, { span: 4, class: "card-panel-col" }, { default: a(() => [n(v, { name: "年度非正常完成数", "text-color": "#626262", "num-color": "#337ECC", "end-val": f.value.improperCompletionByYear || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), n(y, { span: 4, class: "card-panel-col" }, { default: a(() => [n(v, { name: "年度缺勤数", "text-color": "#626262", "num-color": "#337ECC", "end-val": f.value.numberOfAbsencesByYear || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), n(y, { span: 4, class: "card-panel-col" }, { default: a(() => [n(v, { name: "当月正常完成数", "text-color": "#626262", "num-color": "#529B2E", "end-val": f.value.normalCompletionByMonth || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), n(y, { span: 4, class: "card-panel-col" }, { default: a(() => [n(v, { name: "当月非正常完成数", "text-color": "#626262", "num-color": "#529B2E", "end-val": f.value.improperCompletionByMonth || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), n(y, { span: 4, class: "card-panel-col" }, { default: a(() => [n(v, { name: "当月缺勤数", "text-color": "#626262", "num-color": "#529B2E", "end-val": f.value.numberOfAbsencesByMonth || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[Ce, w.value]]), (p(), b(_e, { ref_key: "calendarRef", ref: z, modelValue: m.value, "onUpdate:modelValue": e[7] || (e[7] = (t) => m.value = t), key: m.value.getTime() }, { header: a(() => [u("div", We, [n(s, { modelValue: c.value, "onUpdate:modelValue": e[2] || (e[2] = (t) => c.value = t), options: g(ae).ENUM, type: "enum", default: "" }, null, 8, ["modelValue", "options"]), n(fe, { modelValue: m.value, "onUpdate:modelValue": e[3] || (e[3] = (t) => m.value = t), type: "month", placeholder: "选择月份", clearable: false, teleported: false, style: { width: "150px", "margin-left": "8px" } }, null, 8, ["modelValue"]), n(g(Fe), { style: { "margin-left": "20px" }, colors: re })]), u("div", Je, [n(ve, { style: { "margin-right": "10px" } }, { default: a(() => [n(D, { size: "default", onClick: e[4] || (e[4] = (t) => S("prev-month")) }, { default: a(() => e[13] || (e[13] = [B(" 上个月 ")])), _: 1, __: [13] }), n(D, { size: "default", onClick: e[5] || (e[5] = (t) => S("today")) }, { default: a(() => e[14] || (e[14] = [B(" 今天 ")])), _: 1, __: [14] }), n(D, { size: "default", onClick: e[6] || (e[6] = (t) => S("next-month")) }, { default: a(() => e[15] || (e[15] = [B(" 下个月 ")])), _: 1, __: [15] })]), _: 1 })])]), "date-cell": a(({ data: t }) => {
      var K, Q, W, J, X, Z, ee, te;
      return [u("div", { style: ke(`height: 100%;padding: 8px;${(K = l.map[t.day]) != null && K.completeState ? `background-color:${d.V[(Q = l.map[t.day]) == null ? void 0 : Q.completeState].C}` : ""}`), onClick: (_) => de(t) }, [u("div", Ze, [u("div", { class: Ve(t.isSelected ? "is-selected" : "") }, x(t.day.split("-").slice(1).join("-")), 3), g(j)(l.map[t.day]) ? (p(), b(q, { key: 0, style: { "margin-left": "10px", "font-size": "14px" } }, { default: a(() => {
        var _;
        return [(_ = l.map[t.day]) != null && _.projectInspectionCount ? (p(), b(y, { key: 0, span: 24 }, { default: a(() => {
          var oe;
          return [u("div", null, "巡检点：" + x(((oe = l.map[t.day]) == null ? void 0 : oe.projectInspectionCount) || 0), 1)];
        }), _: 2 }, 1024)) : E("", true)];
      }), _: 2 }, 1024)) : E("", true)]), u("div", et, [(W = l.map[t.day]) != null && W.projectInspectionCount ? (p(), h("div", tt, [u("div", null, "需巡：" + x(((J = l.map[t.day]) == null ? void 0 : J.totalInspect) || 0), 1), u("div", null, "已巡：" + x(((X = l.map[t.day]) == null ? void 0 : X.inspected) || 0), 1), u("div", null, "未巡：" + x(((Z = l.map[t.day]) == null ? void 0 : Z.notInspected) || 0), 1)])) : E("", true), (ee = l.map[t.day]) != null && ee.projectInspectionCount && ((te = l.map[t.day]) != null && te.hazardCount) ? (p(), h("div", ot, [n(ye, { size: "large", type: "warning", effect: "plain", round: "", onClick: he((_) => me(l.map[t.day]), ["stop"]) }, { default: a(() => {
        var _;
        return [B("发现隐患：" + x((_ = l.map[t.day]) == null ? void 0 : _.hazardCount), 1)];
      }), _: 2 }, 1032, ["onClick"])])) : (p(), h("div", nt))])], 12, Xe)];
    }), _: 1 }, 8, ["modelValue"])), n(ge, { ref: "drawerRef", size: "100%", title: "巡检配置", "append-to-body": "", destroyOnClose: "", "custom-class": "inspection-config-drawer", modelValue: k.value, "onUpdate:modelValue": e[8] || (e[8] = (t) => k.value = t) }, { titleRight: a(() => e[16] || (e[16] = [])), content: a(() => [n(Pe, { ref: "inspectionConfigRef", maxHeight: g(ce), permission: g(C), point: H.value, onChangeLineStatus: V, onUserChange: G }, null, 8, ["maxHeight", "permission", "point"])]), _: 1 }, 8, ["modelValue"]), n(Ye, { visible: A.value, "onUpdate:visible": e[9] || (e[9] = (t) => A.value = t), currentDay: $.value, userId: r.value, inspectionSiteOptionType: c.value, point: H.value }, null, 8, ["visible", "currentDay", "userId", "inspectionSiteOptionType", "point"]), n(Ge, { visible: P.value, "onUpdate:visible": e[10] || (e[10] = (t) => P.value = t) }, null, 8, ["visible"]), n(qe, { visible: M.value, "onUpdate:visible": e[11] || (e[11] = (t) => M.value = t), currentDateInfo: Y.value, userId: r.value }, null, 8, ["visible", "currentDateInfo", "userId"])]);
  };
} }, Mt = Ue(lt, [["__scopeId", "data-v-cdec58f4"]]);
export {
  Mt as default
};
