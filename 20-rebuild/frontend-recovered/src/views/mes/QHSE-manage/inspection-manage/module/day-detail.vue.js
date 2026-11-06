import { ref as h } from "vue";
import M from "moment";
import { resolveComponent as A } from "vue";
import { openBlock as r } from "vue";
import { createBlock as T } from "vue";
import { withCtx as n } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as D } from "vue";
import { toDisplayString as k } from "vue";
import { withDirectives as F } from "vue";
import { unref as y } from "vue";
import { createElementBlock as u } from "vue";
import { withModifiers as $ } from "vue";
import { createElementVNode as j } from "vue";
import { Fragment as N } from "vue";
import { renderList as q } from "vue";
import { isRef as z } from "vue";
import { ElTag as W } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { MapLocation as G } from "@element-plus/icons-vue";
import { ElIcon as J } from "element-plus";
import { ElImage as K } from "element-plus";
import { vLoading as P } from "element-plus";
import { c as Q } from "../../../../../modules/inspection-manage-c10227da.js";
import { _ as X, u as Z, o as ee, p as te } from "../../../../../shared/runtime.js";
import ie from "./map-location-dialog.vue.js";
import "../../../../../modules/index-df3c71c0.js";
const ae = { key: 0, class: "tc-success" }, oe = { key: 1, class: "tc-danger" }, ne = { class: "imgs-box" }, se = ["src"], le = { __name: "day-detail", props: { visible: { type: Boolean, default: false }, userId: { type: [Number, String] }, currentDay: { type: String }, point: { type: String, default: "" }, inspectionSiteOptionType: { type: Number } }, emits: ["update:visible"], setup(x, { emit: C }) {
  const b = h(false), I = h({}), U = C, m = x, { visible: f, handleClose: V } = Z({ emit: U, props: m, field: "visible", showHook: B }), { maxHeight: E } = ee({ extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, f), v = h({}), w = h(false);
  function B() {
    H();
  }
  async function H() {
    try {
      w.value = true;
      const e = await Q({ date: M(m.currentDay).startOf("day").valueOf(), userId: m.userId, inspectionSiteOptionType: m.inspectionSiteOptionType });
      e.list = [], e.projectInspectionTaskTimeAndAttachmentDTOS.forEach((t) => {
        var a;
        let l = 0;
        if (t.taskTimeAndAttachmentList.forEach((s) => {
          var p, _;
          s.imgUrls = (_ = (p = s.inspectionAttachmentList) == null ? void 0 : p.filter((d) => {
            var g;
            return ((g = d.name) == null ? void 0 : g.split(".").slice(-1)[0]) !== "mp4";
          })) == null ? void 0 : _.map((d) => d.imageUrl), t.id !== l && (l = t.id, s.mergeSpan = e.patrolsTime), e.list.push({ ...s, inspectionName: t.inspectionName });
        }), ((a = t.taskTimeAndAttachmentList) == null ? void 0 : a.length) < e.patrolsTime) for (let s = 0; s < e.patrolsTime - t.taskTimeAndAttachmentList.length; s++) {
          const p = { inspectionName: t.inspectionName, imgUrls: [], inspectionTime: null };
          t.id !== l && (l = t.id, p.mergeSpan = e.patrolsTime), e.list.push({ ...p });
        }
      }), v.value = e;
    } catch (e) {
      console.log(e);
    } finally {
      w.value = false;
    }
  }
  function L({ row: e, column: t, rowIndex: l, columnIndex: a }) {
    if (a === 1) return e.mergeSpan ? { rowspan: e.mergeSpan, colspan: 1 } : { rowspan: 0, colspan: 0 };
  }
  function O(e) {
    e.inspectionTime && (b.value = true, I.value = e);
  }
  return (e, t) => {
    const l = W, a = Y, s = G, p = J, _ = K, d = A("common-table"), g = A("common-dialog"), R = P;
    return r(), T(g, { title: "巡检记录", modelValue: y(f), "onUpdate:modelValue": t[1] || (t[1] = (i) => z(f) ? f.value = i : null), top: "5vh", width: "840px", "before-close": y(V) }, { titleAfter: n(() => [o(l, { effect: "plain" }, { default: n(() => [D(k(x.currentDay), 1)]), _: 1 }), o(l, { effect: "plain", type: "success" }, { default: n(() => [D(k(v.value.userName), 1)]), _: 1 })]), titleRight: n(() => t[2] || (t[2] = [])), default: n(() => [F((r(), T(d, { data: v.value.list, "span-method": L, "max-height": y(E), style: { width: "100%" } }, { default: n(() => [o(a, { label: "序号", type: "index", align: "center", width: "60" }), o(a, { prop: "inspectionName", "show-overflow-tooltip": true, label: "巡检点", align: "center", width: "140" }), o(a, { "show-overflow-tooltip": true, label: "打卡时间", align: "center", width: "100" }, { default: n(({ row: { sourceRow: i } }) => [i.inspectionTime ? (r(), u("span", ae, k(y(te)(i.inspectionTime, "{h}:{i}")), 1)) : (r(), u("span", oe, "未打卡"))]), _: 1 }), o(a, { prop: "position", "show-overflow-tooltip": true, label: "定位", align: "center", width: "140" }, { default: n(({ row: i }) => [o(p, { onClick: $((c) => O(i), ["stop"]), size: 22, color: i.inspectionTime ? "#67C23A" : "#409EFF" }, { default: n(() => [o(s)]), _: 2 }, 1032, ["onClick", "color"])]), _: 1 }), o(a, { "show-overflow-tooltip": true, label: "巡检视图", align: "left", "min-width": "140" }, { default: n(({ row: { sourceRow: i } }) => [j("div", ne, [(r(true), u(N, null, q(i.inspectionAttachmentList, (c) => {
      var S;
      return r(), u(N, { key: c.id }, [((S = c.name) == null ? void 0 : S.split(".").slice(-1)[0]) !== "mp4" ? (r(), T(_, { "preview-src-list": i.imgUrls, "initial-index": 1, key: c.id, src: c.tinyImageUrl, "preview-teleported": "" }, null, 8, ["preview-src-list", "src"])) : (r(), u("video", { controls: "controls", poster: "", width: "100", height: "60", ref_for: true, ref: `media_${c.id}`, autoplay: false, loop: false, muted: true, key: c.imageUrl, src: c.imageUrl }, null, 8, se))], 64);
    }), 128))])]), _: 1 }), o(a, { prop: "remark", "show-overflow-tooltip": true, label: "巡检结果", align: "center" })]), _: 1 }, 8, ["data", "max-height"])), [[R, w.value]]), o(ie, { visible: b.value, "onUpdate:visible": t[0] || (t[0] = (i) => b.value = i), "detail-data": I.value, point: m.point }, null, 8, ["visible", "detail-data", "point"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ue = X(le, [["__scopeId", "data-v-58bd8f58"]]);
export {
  ue as default
};
