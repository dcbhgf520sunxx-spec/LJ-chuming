import { _ as V } from "../../../modules/black-bg-05289b55.js";
import { f as C } from "../../../modules/qr-scan-info-657de68e.js";
import { useRoute as L } from "vue-router";
import { ref as l } from "vue";
import { computed as R } from "vue";
import { watchEffect as D } from "vue";
import { ElLoading as F } from "element-plus";
import { openBlock as r } from "vue";
import { createElementBlock as u } from "vue";
import { createElementVNode as t } from "vue";
import { toDisplayString as e } from "vue";
import { unref as m } from "vue";
import { createCommentVNode as c } from "vue";
import { Fragment as A } from "vue";
import { _ as O, s as P, c as j, D as M, w as p, i as _ } from "../../../shared/runtime.js";
import { c as W } from "../../../modules/index-f09320a8.js";
import "../../../modules/externalRequest-4308f5b0.js";
const Q = { class: "app-container" }, $ = { class: "title-drawer" }, z = { class: "subtitle" }, G = { class: "info" }, K = { key: 0 }, U = { class: "subtitle" }, H = { class: "info" }, J = { key: 0 }, X = { key: 1 }, Y = { class: "subtitle" }, Z = { class: "info" }, ee = { __name: "artifact", setup(ae) {
  const o = L(), a = l({ name: "", drawingNumber: "", material: "", specification: "", length: "", grossWeight: "", area: "", taskQuantity: "", projectShortName: "", monomerName: "", areaName: "", factoryName: "", productionLineName: "" }), q = o.query.id, E = o.query.factoryId, I = o.query.taskId, d = l(+o.query.wt), f = l(!!+o.query.sl), S = l(!!+o.query.sa), T = l(!!+o.query.sm), g = l(o.query.lang || "zh"), h = R(() => o.query.type), s = l();
  D(() => {
    g.value && h.value && (s.value = W({ productType: h.value, language: g.value }));
  });
  const x = { id: q, factoryId: E, taskId: I }, y = window.location.href.split(P.QR_SCAN_ARTIFACT_TASK)[0].split("/#")[0];
  console.log(y), B(y, x);
  async function B(w, i) {
    const v = F.service({ lock: true, text: "正在加载构件信息", background: "rgba(0, 0, 0, 0.7)", fullscreen: true });
    try {
      const n = await C(w, i);
      switch (n.surfaceArea = j(n.surfaceArea, "mm²", "㎡", M.COM_AREA__M2), a.value = n, d.value) {
        case p.NET.V:
          a.value.weight = a.value.netWeight.toFixed(2);
          break;
        case p.GROSS.V:
          a.value.weight = a.value.grossWeight.toFixed(2);
          break;
        case p.NONE.V:
          a.value.weight = "";
          break;
        default:
      }
      console.log(a);
    } catch (n) {
      console.log("获取构件信息失败", n);
    } finally {
      v.close();
    }
  }
  return (w, i) => {
    var v, n, N, k, b;
    return r(), u("div", Q, [i[0] || (i[0] = t("img", { class: "img-bg", src: V }, null, -1)), t("div", $, e(`${a.value.name} ${a.value.serialNumber}`), 1), t("span", z, e(s.value("baseInfo")), 1), t("div", G, [t("span", null, e(s.value("name")) + "：" + e(a.value.name || "-"), 1), t("span", null, e(s.value("code")) + "：" + e(a.value.serialNumber || "-"), 1), t("span", null, e(s.value("figure")) + "：" + e(a.value.drawingNumber || "-"), 1), t("span", null, e(s.value("material")) + "：" + e(a.value.material || "-"), 1), t("span", null, e(s.value("Specifications")) + "：" + e(a.value.specification || "-"), 1), t("span", null, e(s.value("length")) + "：" + e(m(_)(a.value.length) ? a.value.length + " mm" : "-"), 1), m(p).NONE.V !== d.value ? (r(), u("span", K, e(s.value("weight")) + "：" + e(m(_)(a.value.weight) ? a.value.weight + " kg" : "-"), 1)) : c("", true), t("span", null, e(s.value("area")) + "：" + e(m(_)(a.value.surfaceArea) ? a.value.surfaceArea + " ㎡" : "-"), 1)]), t("span", U, e(s.value("usePart")), 1), t("div", H, [t("span", null, e(s.value("project")) + "：" + e(((v = a.value.project) == null ? void 0 : v.shortName) || "-"), 1), T.value ? (r(), u("span", J, e(s.value("monomer")) + "：" + e(((n = a.value.monomer) == null ? void 0 : n.name) || "-"), 1)) : c("", true), S.value ? (r(), u("span", X, e(s.value("region")) + "：" + e(((N = a.value.area) == null ? void 0 : N.name) || "-"), 1)) : c("", true)]), f.value ? (r(), u(A, { key: 0 }, [t("span", Y, e(s.value("productionInfo")), 1), t("div", Z, [f.value ? (r(), u(A, { key: 0 }, [t("span", null, e(s.value("factory")) + "：" + e(((k = a.value.factory) == null ? void 0 : k.name) || "-"), 1), t("span", null, e(s.value("productionLine")) + "：" + e(((b = a.value.productionLine) == null ? void 0 : b.name) || "-"), 1)], 64)) : c("", true)])], 64)) : c("", true)]);
  };
} }, ue = O(ee, [["__scopeId", "data-v-03c53f35"]]);
export {
  ue as default
};
